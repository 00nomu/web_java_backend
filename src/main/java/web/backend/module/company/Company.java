package web.backend.module.company;

import com.fasterxml.jackson.annotation.JsonProperty;
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

/**
 * Company 테이블은 모바일에서 라우터에 사용되지 않습니다.
 */

@Entity
@Getter
@NoArgsConstructor
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_index")
    @JsonProperty(value = "")
    private Integer companyIndex;

    @Column(unique = true)
    private String companyCode;

    private String companyName;

    private String companyTel;

    private String companyOwnerName;

    private String companyMemo;

    @CreatedDate
    @Column( updatable = false)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime companyCreated;

    @LastModifiedDate
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime companyUpdated;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        companyCreated = now;
        companyUpdated = now;
    }

    @PreUpdate
    public void preUpdate() {
        companyUpdated = LocalDateTime.now();
    }


    public Company(
            String companyCode,
            String companyName,
            String companyTel,
            String companyOwnerName,
            String companyMemo
    ) {
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.companyTel = companyTel;
        this.companyOwnerName = companyOwnerName;
        this.companyMemo = companyMemo;
    }

    public void update( Company company ) {
        this.companyCode = company.getCompanyCode();
        this.companyName = company.getCompanyName();
        this.companyTel = company.getCompanyTel();
        this.companyOwnerName = company.getCompanyOwnerName();
        this.companyMemo = company.getCompanyMemo();
    }
}
