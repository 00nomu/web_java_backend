package mobile.backend.module.file;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mobile.backend.response.CommonResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {

    private final FileService service;

    @GetMapping
    public CommonResponse<List<File>> findAll() {
        return new CommonResponse<List<File>>(true, service.findAll());
    }

    @GetMapping("/{id}")
    public CommonResponse<File> findByIndex(@PathVariable(value = "id") int id) {
        return new CommonResponse<File>(true, service.findByIndex(id));
    }

    @PostMapping
    public CommonResponse<String> save(@RequestBody File file) {
        return new CommonResponse<String>(true, service.save(file));
    }

    @DeleteMapping
    public CommonResponse<String> delete(@RequestParam int id) {
        return new CommonResponse<String>(true, service.delete(id));
    }

    @PostMapping("/upload")
    public CommonResponse<String> upload(
            @RequestParam("file_customer_code") String fileCustomerCode,
            @RequestParam("file_worker_code") String fileWorkerCode,
            @RequestParam("file_name") String fileName,
            @RequestParam("file_where") String fileWhere,
            @RequestParam("file_kinds") String fileKinds,
            @RequestParam("file_object") MultipartFile fileObject
    ) throws IOException {
        log.info("customerCode={}", fileCustomerCode);
        log.info("fileName={}", fileName);
        log.info("fileWhere={}", fileWhere);
        log.info("fileKinds={}", fileKinds);
        log.info("multipartFile={}", fileObject);
        return new CommonResponse<String>(
                true,
                service.upload(
                        fileCustomerCode,
                        fileWorkerCode,
                        fileName,
                        fileWhere,
                        fileKinds,
                        fileObject
                ));
    }

}
