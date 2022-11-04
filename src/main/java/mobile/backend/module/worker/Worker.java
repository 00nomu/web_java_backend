package mobile.backend.module.worker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mobile.backend.module.worker.repository.WorkerUpdateDto;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workerIndex;

    private String workerMuserId;

    @Column(columnDefinition = "TEXT")
    private String workerMuserMemo;

    private LocalDateTime workerPrivacy;

    private String workerCodeNumber;

    private String workerBirthday;

    private String workerCustomerCode;

    private String workerName;

    private String workerGetDate;

    private String workerLostDate;

    private String workerNationalPension;

    private String workerHealthInsurance;

    private String workerEmploymentInsurance;

    private String workerLongcareInsurance;

    private String workerIncomeTax;

    private String workerResidentTax;

    private String workerTel;

    @Column(columnDefinition = "LONGTEXT")
    private String workerWageTerm;

    @Column(columnDefinition = "LONGTEXT")
    private String workerWageDate;

    @Column(columnDefinition = "BIT")
    private String workerWageBoolean;

    @Column(columnDefinition = "BIT")
    private String workerInsuranceBoolean;

    @Column(columnDefinition = "TEXT")
    private String workerInsuranceMemo;

    private String workerEmployType;

    private String workerStartDate;

    private String workerEndDate;

    private String workerMemo;

    private String workerAddress;

    private String workerAddressDetail;

    @Column(columnDefinition = "BIT")
    private int workerDeleteStatus;

    @Column(columnDefinition = "LONGTEXT")
    private String workerWeeklyData;

    private String workerWorkType;

    private String workerWorkTypeDetail;

    private String workerPayType;

    private String workerPay;

    private String workerRefreshType;

    private String workerMonthlyRefreshCount;

    private String workerWeeklyWorkCount;

    private String workerStartTime;

    private String workerEndTime;

    private String workerRefreshDailyHour;

    private String workerRefreshNightHour;

    private String workerGeunrojaRegNum1;

    private String workerGeunrojaRegNum2;

    private String workerChideukCost;

    private int workerAvgWorkerCount;

    @Column(columnDefinition = "LONGTEXT")
    private String workerWeeklyPayData;

    private String workerStandardYear;

    private int workerSingoStatus;

    private int workerChwideukStatus;

    private int workerSangsilStatus;

    private int workerJungjungStatus;

    @Column(columnDefinition = "LONGTEXT")
    private String workerCustomerData;

    private String workerRefreshDailyMinute;

    private String workerRefreshNightMinute;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime workerCreated;

    @LastModifiedDate
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime workerUpdated;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        workerCreated = now;
        workerUpdated = now;
    }

    @PreUpdate
    public void preUpdate() {
        workerUpdated = LocalDateTime.now();
    }

    public Worker (
     String workerMuserId,
     String workerMuserMemo,
     LocalDateTime workerPrivacy,
     String workerCodeNumber,
     String workerBirthday,
     String workerCustomerCode,
     String workerName,
     String workerGetDate,
     String workerLostDate,
     String workerNationalPension,
     String workerHealthInsurance,
     String workerEmploymentInsurance,
     String workerLongcareInsurance,
     String workerIncomeTax,
     String workerResidentTax,
     String workerTel,
     String workerWageTerm,
     String workerWageDate,
     String workerInsuranceMemo,
     String workerEmployType,
     String workerStartDate,
     String workerEndDate,
     String workerMemo,
     String workerAddress,
     String workerAddressDetail,
     String workerWeeklyData,
     String workerWorkType,
     String workerWorkTypeDetail,
     String workerPayType,
     String workerPay,
     String workerRefreshType,
     String workerMonthlyRefreshCount,
     String workerWeeklyWorkCount,
     String workerStartTime,
     String workerEndTime,
     String workerRefreshDailyHour,
     String workerRefreshNightHour,
     String workerGeunrojaRegNum1,
     String workerGeunrojaRegNum2,
     String workerChideukCost,
     int workerAvgWorkerCount,
     String workerWeeklyPayData,
     String workerStandardYear,
     int workerSingoStatus,
     int workerChwideukStatus,
     int workerSangsilStatus,
     int workerJungjungStatus,
     String workerCustomerData,
     String workerRefreshDailyMinute,
     String workerRefreshNightMinute
    ) {
        this.workerMuserId = workerMuserId;
        this.workerMuserMemo = workerMuserMemo;
        this.workerPrivacy = workerPrivacy;
        this.workerCodeNumber = workerCodeNumber;
        this.workerBirthday = workerBirthday;
        this.workerCustomerCode = workerCustomerCode;
        this.workerName = workerName;
        this.workerGetDate = workerGetDate;
        this.workerLostDate = workerLostDate;
        this.workerNationalPension = workerNationalPension;
        this.workerHealthInsurance = workerHealthInsurance;
        this.workerEmploymentInsurance = workerEmploymentInsurance;
        this.workerLongcareInsurance = workerLongcareInsurance;
        this.workerIncomeTax = workerIncomeTax;
        this.workerResidentTax = workerResidentTax;
        this.workerTel = workerTel;
        this.workerWageTerm = workerWageTerm;
        this.workerWageDate = workerWageDate;
        this.workerInsuranceMemo = workerInsuranceMemo;
        this.workerEmployType = workerEmployType;
        this.workerStartDate = workerStartDate;
        this.workerEndDate = workerEndDate;
        this.workerMemo = workerMemo;
        this.workerAddress = workerAddress;
        this.workerAddressDetail = workerAddressDetail;
        this.workerWeeklyData = workerWeeklyData;
        this.workerWorkType = workerWorkType;
        this.workerWorkTypeDetail = workerWorkTypeDetail;
        this.workerPayType = workerPayType;
        this.workerPay = workerPay;
        this.workerRefreshType = workerRefreshType;
        this.workerMonthlyRefreshCount = workerMonthlyRefreshCount;
        this.workerWeeklyWorkCount = workerWeeklyWorkCount;
        this.workerStartTime = workerStartTime;
        this.workerEndTime = workerEndTime;
        this.workerRefreshDailyHour = workerRefreshDailyHour;
        this.workerRefreshNightHour = workerRefreshNightHour;
        this.workerGeunrojaRegNum1 = workerGeunrojaRegNum1;
        this.workerGeunrojaRegNum2 = workerGeunrojaRegNum2;
        this.workerChideukCost = workerChideukCost;
        this.workerAvgWorkerCount = workerAvgWorkerCount;
        this.workerWeeklyPayData = workerWeeklyPayData;
        this.workerStandardYear = workerStandardYear;
        this.workerSingoStatus = workerSingoStatus;
        this.workerChwideukStatus = workerChwideukStatus;
        this.workerSangsilStatus = workerSangsilStatus;
        this.workerJungjungStatus = workerJungjungStatus;
        this.workerCustomerData = workerCustomerData;
        this.workerRefreshDailyMinute = workerRefreshDailyMinute;
        this.workerRefreshNightMinute = workerRefreshNightMinute;
    }

    public void update (WorkerUpdateDto.ContentClass worker) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        this.workerMuserId = worker.getWorkerMuserId();
        this.workerMuserMemo = worker.getWorkerMuserMemo();
        this.workerPrivacy = worker.getWorkerPrivacy();
        this.workerCodeNumber = worker.getWorkerCodeNumber();
        this.workerBirthday = worker.getWorkerBirthday();
        this.workerCustomerCode = worker.getWorkerCustomerCode();
        this.workerName = worker.getWorkerName();
        this.workerGetDate = worker.getWorkerGetDate();
        this.workerLostDate = worker.getWorkerLostDate();
        this.workerNationalPension = worker.getWorkerNationalPension();
        this.workerHealthInsurance = worker.getWorkerHealthInsurance();
        this.workerEmploymentInsurance = worker.getWorkerEmploymentInsurance();
        this.workerLongcareInsurance = worker.getWorkerLongcareInsurance();
        this.workerIncomeTax = worker.getWorkerIncomeTax();
        this.workerResidentTax = worker.getWorkerResidentTax();
        this.workerTel = worker.getWorkerTel();
        this.workerWageTerm = worker.getWorkerWageTerm();
        this.workerWageDate = worker.getWorkerWageDate();
        this.workerInsuranceMemo = worker.getWorkerInsuranceMemo();
        this.workerEmployType = worker.getWorkerEmployType();
        this.workerStartDate = worker.getWorkerStartDate();
        this.workerEndDate = worker.getWorkerEndDate();
        this.workerMemo = worker.getWorkerMemo();
        this.workerAddress = worker.getWorkerAddress();
        this.workerAddressDetail = worker.getWorkerAddressDetail();
        this.workerWorkType = worker.getWorkerWorkType();
        this.workerWorkTypeDetail = worker.getWorkerWorkTypeDetail();
        this.workerPayType = worker.getWorkerPayType();
        this.workerPay = worker.getWorkerPay();
        this.workerRefreshType = worker.getWorkerRefreshType();
        this.workerMonthlyRefreshCount = worker.getWorkerMonthlyRefreshCount();
        this.workerWeeklyWorkCount = worker.getWorkerWeeklyWorkCount();
        this.workerStartTime = worker.getWorkerStartTime();
        this.workerEndTime = worker.getWorkerEndTime();
        this.workerRefreshDailyHour = worker.getWorkerRefreshDailyHour();
        this.workerRefreshNightHour = worker.getWorkerRefreshNightHour();
        this.workerGeunrojaRegNum1 = worker.getWorkerGeunrojaRegNum1();
        this.workerGeunrojaRegNum2 = worker.getWorkerGeunrojaRegNum2();
        this.workerChideukCost = worker.getWorkerChideukCost();
        this.workerAvgWorkerCount = worker.getWorkerAvgWorkerCount();
        this.workerStandardYear = worker.getWorkerStandardYear();
        this.workerSingoStatus = worker.getWorkerSingoStatus();
        this.workerChwideukStatus = worker.getWorkerChwideukStatus();
        this.workerSangsilStatus = worker.getWorkerSangsilStatus();
        this.workerJungjungStatus = worker.getWorkerJungjungStatus();

        this.workerWeeklyData = mapper.writeValueAsString(worker.getWorkerWeeklyData());
        this.workerWeeklyPayData = mapper.writeValueAsString(worker.getWorkerWeeklyPayData());
        this.workerCustomerData = mapper.writeValueAsString(worker.getWorkerCustomerData());

        this.workerRefreshDailyMinute = worker.getWorkerRefreshDailyMinute();
        this.workerRefreshNightMinute = worker.getWorkerRefreshNightMinute();
    }
}
