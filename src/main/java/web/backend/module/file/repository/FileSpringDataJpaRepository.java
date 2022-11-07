package web.backend.module.file.repository;

import web.backend.module.file.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FileSpringDataJpaRepository extends JpaRepository<File, Integer> {

    Optional<File> findByFileIndex(int id);

    Optional<File> findByFileCustomerCode(String code);

    @Query("select f from File f" +
            " where f.fileWhere = :fileWhere" +
            " and f.fileCustomerCode = :fileCustomerCode" +
            " and f.fileWorkerCode = :fileWorkerCode" +
            " and f.fileKinds = :fileKinds")
    List<File> findByOthers(
            @Param("fileWhere") String fileWhere,
            @Param("fileCustomerCode") String fileCustomerCode,
            @Param("fileWorkerCode") String fileWorkerCode,
            @Param("fileKinds") String fileKinds
    );

}
