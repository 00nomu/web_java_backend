package mobile.backend.module.muser;

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
@Table(name = "muser_info")
public class Muser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer muserIndex;

    @Column(unique = true)
    private String muserId;

    private String muserPassword;

    @Column(columnDefinition = "BIT")
    private int muserMobileSignup;

    private int muserPoint;

    private String muserName;

    private String muserTel;

    private String muserPaymentsType;

    private int muserWorkerLimit;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime muserCreated;

    @LastModifiedDate
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime muserUpdated;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        muserCreated = now;
        muserUpdated = now;
    }

    @PreUpdate
    public void preUpdate() {
        muserUpdated = LocalDateTime.now();
    }

    public Muser(
            String muserId,
            String muserPassword,
            int muserMobileSignup,
            int muserPoint,
            String muserName,
            String muserTel,
            String muserPaymentsType,
            int muserWorkerLimit
            ) {
        this.muserId = muserId;
        this.muserPassword = muserPassword;
        this.muserMobileSignup = muserMobileSignup;
        this.muserPoint = muserPoint;
        this.muserName = muserName;
        this.muserTel = muserTel;
        this.muserPaymentsType = muserPaymentsType;
        this.muserWorkerLimit = muserWorkerLimit;
    }

    public void update(Muser muser) {
        this.muserId = muser.getMuserId();
        this.muserPassword = muser.getMuserPassword();
        this.muserMobileSignup = muser.getMuserMobileSignup();
        this.muserPoint = muser.getMuserPoint();
        this.muserName = muser.getMuserName();
        this.muserTel = muser.getMuserTel();
        this.muserPaymentsType = muser.getMuserPaymentsType();
        this.muserWorkerLimit = muser.getMuserWorkerLimit();
    }

}
