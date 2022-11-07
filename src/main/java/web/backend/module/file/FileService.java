package web.backend.module.file;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.backend.aws.S3Uploader;
import web.backend.module.file.repository.FileQueryRepository;
import web.backend.module.file.repository.FileSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FileService {

    private final FileQueryRepository queryRepository;
    private final FileSpringDataJpaRepository springDataJpaRepository;

    @Autowired
    private S3Uploader s3Uploader;


    public List<File> findAll() {
        return springDataJpaRepository.findAll();
    }

    public File findByIndex(Integer id) {
        return springDataJpaRepository.findByFileIndex(id).get();
    }

    public File findByFileCustomerCode(String id) {
        return springDataJpaRepository.findByFileCustomerCode(id).get();
    }

    public String save(File file) {
        springDataJpaRepository.save(file);
        return "ok";
    }

    public String delete(Integer id) {
        springDataJpaRepository.deleteById(id);
        return "ok";
    }

    public String upload(
            String fileCustomerCode,
            String fileWorkerCode,
            String fileName,
            String fileWhere,
            String fileKinds,
            MultipartFile fileObject ) throws IOException {

        if(fileObject.isEmpty()) {
        }
        else {
            LocalDateTime now = LocalDateTime.now();

            String fileType = Objects.equals(fileObject.getContentType(), "application/pdf") ? ".pdf" : ".png";

            String fileLocation = "";
            if(Objects.equals(fileWhere, "customer")) {
                fileLocation += "customer/";
            }
            else {
                fileLocation += "worker/";
            }
            fileLocation += fileCustomerCode + "/";
            fileLocation += fileKinds + "/";
            fileLocation += now.toString();
            fileLocation += fileType;

            String storedFileName = s3Uploader.upload(fileObject,fileLocation);

            log.info("fileName = {}", storedFileName);

            List<File> byOthers = springDataJpaRepository.findByOthers(
                    fileWhere,
                    fileCustomerCode,
                    fileWorkerCode,
                    fileKinds
            );

            if(byOthers.isEmpty()) {
                File file = new File(
                        fileName,
                        fileKinds,
                        fileWhere,
                        fileCustomerCode,
                        fileWorkerCode,
                        fileLocation
                );
                springDataJpaRepository.save(file);
            }
            else {
                for(File file : byOthers) {
                    file.update( fileName, fileLocation );
                }
            }
        }
        return "ok";
    }
}
