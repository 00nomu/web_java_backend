package web.backend.module.file;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name="file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fileIndex;

    @Column(columnDefinition = "TEXT")
    private String fileName;

    private String fileKinds;

    private String fileWhere;

    private String fileCustomerCode;

    private String fileWorkerCode;

    private String fileLocation;

    @CreatedDate
    @Column(name="fileCreated", updatable = false)
    private LocalDateTime fileCreated;

    @LastModifiedDate
    @Column(name="fileUpdated")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime fileUpdated;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        fileCreated = now;
        fileUpdated = now;
    }

    @PreUpdate
    public void preUpdate() {
        fileUpdated = LocalDateTime.now();
    }

    public File(
            String fileName,
            String fileKinds,
            String fileWhere,
            String fileCustomerCode,
            String fileWorkerCode,
            String fileLocation
    ) {
        this.fileName = fileName;
        this.fileKinds = fileKinds;
        this.fileWhere = fileWhere;
        this.fileCustomerCode = fileCustomerCode;
        this.fileWorkerCode = fileWorkerCode;
        this.fileLocation = fileLocation;
    }

    public void update(
            String fileName,
            String fileLocation
    ) {
        this.fileName = fileName;
        this.fileLocation = fileLocation;
    }



}
