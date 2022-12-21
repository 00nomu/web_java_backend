package web.backend.module.warrant;

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
@Table(name = "warrant")
public class Warrant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer warrantIndex;

    private String warrantCompanyCode;

    private String warrantOwnerName;

    private String warrantRegNumber;

    private String warrantCompanyName;

    private String warrantCompanyAddress;

    private String warrantCompanyTel;

    private String warrantEmail;

    @Column(columnDefinition = "TEXT")
    private String warrantSign;

    @Column(columnDefinition = "LONGTEXT")
    private String warrantSignPad;


    @Column(columnDefinition = "LONGTEXT")
    private String warrantStampImage;

    private String warrantSignDate;

    private String warrantSendDate;

    private int warrantCompanyType;

    private String warrantManageCode;

    private int warrantLookupStatus;

    @Column(columnDefinition = "TINYINT")
    private int warrantSpecialPeopleBoolean;

    @Column(columnDefinition = "TEXT")
    private String warrantSpecialPeoples;

    @Column(columnDefinition = "TEXT")
    private String warrantSpecialPeopleResult;

    @Column(columnDefinition = "TINYINT")
    private int warrantRefundBoolean;

    private String warrantRefundAmount;

    private int warrantMainType;

    @Column(columnDefinition = "TEXT")
    private String warrantCompanyAddressDetail;

    private String warrantRegNumber2;

    @Column(columnDefinition = "TEXT")
    private String warrantContents;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime warrantCreated;

    @LastModifiedDate
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime warrantUpdated;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        warrantCreated = now;
        warrantUpdated = now;
    }

    @PreUpdate
    public void preUpdate() {
        warrantUpdated = LocalDateTime.now();
    }

    public Warrant(
            String warrantCompanyCode,
            String warrantOwnerName,
            String warrantRegNumber,
            String warrantCompanyName,
            String warrantCompanyAddress,
            String warrantCompanyTel,
            String warrantEmail,
            String warrantSign,
            String warrantSignPad,
            String warrantStampImage,
            String warrantSignDate,
            String warrantSendDate,
            int warrantCompanyType,
            String warrantManageCode,
            int warrantLookupStatus,
            int warrantSpecialPeopleBoolean,
            String warrantSpecialPeoples,
            String warrantSpecialPeopleResult,
            int warrantRefundBoolean,
            String warrantRefundAmount,
            int warrantMainType,
            String warrantCompanyAddressDetail,
            String warrantRegNumber2,
            String warrantContents
    ) {
        this.warrantCompanyCode = warrantCompanyCode;
        this.warrantOwnerName = warrantOwnerName;
        this.warrantRegNumber = warrantRegNumber;
        this.warrantCompanyName = warrantCompanyName;
        this.warrantCompanyAddress = warrantCompanyAddress;
        this.warrantCompanyTel = warrantCompanyTel;
        this.warrantEmail = warrantEmail;
        this.warrantSign = warrantSign;
        this.warrantSignPad = warrantSignPad;
        this.warrantStampImage = warrantStampImage;
        this.warrantSignDate = warrantSignDate;
        this.warrantSendDate = warrantSendDate;
        this.warrantCompanyType = warrantCompanyType;
        this.warrantManageCode = warrantManageCode;
        this.warrantLookupStatus = warrantLookupStatus;
        this.warrantSpecialPeopleBoolean = warrantSpecialPeopleBoolean;
        this.warrantSpecialPeoples = warrantSpecialPeoples;
        this.warrantSpecialPeopleResult = warrantSpecialPeopleResult;
        this.warrantRefundBoolean = warrantRefundBoolean;
        this.warrantRefundAmount = warrantRefundAmount;
        this.warrantMainType = warrantMainType;
        this.warrantCompanyAddressDetail = warrantCompanyAddressDetail;
        this.warrantRegNumber2 = warrantRegNumber2;
        this.warrantContents = warrantContents;
    }

    public void update(Warrant warrant) {
        this.warrantCompanyCode = warrant.getWarrantCompanyCode();
        this.warrantOwnerName = warrant.getWarrantOwnerName();
        this.warrantRegNumber = warrant.getWarrantRegNumber();
        this.warrantCompanyName = warrant.getWarrantCompanyName();
        this.warrantCompanyAddress = warrant.getWarrantCompanyAddress();
        this.warrantCompanyTel = warrant.getWarrantCompanyTel();
        this.warrantEmail = warrant.getWarrantEmail();
        this.warrantSign = warrant.getWarrantSign();
        this.warrantSignPad = warrant.getWarrantSignPad();
        this.warrantStampImage = warrant.getWarrantStampImage();

        this.warrantSignDate = warrant.getWarrantSignDate();
        this.warrantSendDate = warrant.getWarrantSendDate();
        this.warrantCompanyType = warrant.getWarrantCompanyType();
        this.warrantManageCode = warrant.getWarrantManageCode();
        this.warrantLookupStatus = warrant.getWarrantLookupStatus();
        this.warrantSpecialPeopleBoolean = warrant.getWarrantSpecialPeopleBoolean();
        this.warrantSpecialPeoples = warrant.getWarrantSpecialPeoples();
        this.warrantSpecialPeopleResult = warrant.getWarrantSpecialPeopleResult();
        this.warrantRefundBoolean = warrant.getWarrantRefundBoolean();
        this.warrantRefundAmount = warrant.getWarrantRefundAmount();
        this.warrantMainType = warrant.getWarrantMainType();
        this.warrantCompanyAddressDetail = warrant.getWarrantCompanyAddressDetail();
        this.warrantRegNumber2 = warrant.getWarrantRegNumber2();
        this.warrantContents = warrant.getWarrantContents();
    }

    public void lookupComplete() {
        this.warrantLookupStatus = 1;
    }
}
