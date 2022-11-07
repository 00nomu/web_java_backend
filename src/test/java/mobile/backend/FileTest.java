package mobile.backend;

import lombok.extern.slf4j.Slf4j;
import web.backend.module.file.File;
import web.backend.module.file.repository.FileSpringDataJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(true)
@Slf4j
public class FileTest {

    @Autowired
    FileSpringDataJpaRepository springDataJpaRepository;

    @Test
    public void 파일찾기테스트() {
        Optional<File> byOthers = springDataJpaRepository.findByOthers("worker");
        log.info("result ={}", byOthers);
    }
}
