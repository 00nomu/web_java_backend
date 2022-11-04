package mobile.backend.module.customer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mobile.backend.module.customer.repository.CustomerUpdateDto;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerIndex;

    private String customerCode;

    private String customerCompanyCode;

    private String customerMuserId;

    @Column(columnDefinition = "TEXT")
    private String customerMuserMemo;

    private String customerCreateName;

    private String customerCreateRoute;

    private String customerDepositDate;

    private String customerBillBoolean;

    private String customerName;

    private String customerPassword;

    private String customerAddress;

    private String customerAddressDetail;

    private String customerStatus;

    private String customerTel;

    private String customerInsuranceCost;

    private String customerSetCost;

    private String customerManageCost;

    private String customerOwnerName;

    private String customerFourInsuranceName;

    private String customerMainType;

    private String customerSubType;

    private String customerSupportFee;

    @Column(columnDefinition = "LONGTEXT")
    private String customerMemo;

    private int customerDeleteStatus;

    private String customerGwanriNo;

    @Column(columnDefinition = "LONGTEXT")
    private String customerInsuranceDivision;

    private int customerScaleStatus;

    private int customerSamusuimStatus;

    private int customerSungribStatus;

    private String customerCalcBasicDate;

    private int customerCalcAverageWorkerCount;

    @Column(columnDefinition = "LONGTEXT")
    private String customerCalcWorkDay;

    @Column(columnDefinition = "LONGTEXT")
    private String customerCalcDayArray;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime customerCreated;

    @LastModifiedDate
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime customerUpdated;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        customerCreated = now;
        customerUpdated = now;
    }

    @PreUpdate
    public void preUpdate() {
        customerUpdated = LocalDateTime.now();
    }

    public Customer(
            String customerCode,
            String customerCompanyCode,
            String customerMuserId,
            String customerMuserMemo,
            String customerCreateName,
            String customerCreateRoute,
            String customerDepositDate,
            String customerBillBoolean,
            String customerName,
            String customerPassword,
            String customerAddress,
            String customerAddressDetail,
            String customerStatus,
            String customerTel,
            String customerInsuranceCost,
            String customerSetCost,
            String customerManageCost,
            String customerOwnerName,
            String customerFourInsuranceName,
            String customerMainType,
            String customerSubType,
            String customerSupportFee,
            String customerMemo,
            int customerDeleteStatus,
            String customerGwanriNo,
            String customerInsuranceDivision,
            int customerScaleStatus,
            int customerSamusuimStatus,
            int customerSungribStatus,
            String customerCalcBasicDate,
            int customerCalcAverageWorkerCount
    ) {
        this.customerCode = customerCode;
        this.customerCompanyCode = customerCompanyCode;
        this.customerMuserId = customerMuserId;
        this.customerMuserMemo = customerMuserMemo;
        this.customerCreateName = customerCreateName;
        this.customerCreateRoute = customerCreateRoute;
        this.customerDepositDate = customerDepositDate;
        this.customerBillBoolean = customerBillBoolean;
        this.customerName = customerName;
        this.customerPassword = customerPassword;
        this.customerAddress = customerAddress;
        this.customerAddressDetail = customerAddressDetail;
        this.customerStatus = customerStatus;
        this.customerTel = customerTel;
        this.customerInsuranceCost = customerInsuranceCost;
        this.customerSetCost = customerSetCost;
        this.customerManageCost = customerManageCost;
        this.customerOwnerName = customerOwnerName;
        this.customerFourInsuranceName = customerFourInsuranceName;
        this.customerMainType = customerMainType;
        this.customerSubType = customerSubType;
        this.customerSupportFee = customerSupportFee;
        this.customerMemo = customerMemo;
        this.customerDeleteStatus = customerDeleteStatus;
        this.customerGwanriNo = customerGwanriNo;
        this.customerInsuranceDivision = customerInsuranceDivision;
        this.customerScaleStatus = customerScaleStatus;
        this.customerSamusuimStatus = customerSamusuimStatus;
        this.customerSungribStatus = customerSungribStatus;
        this.customerCalcBasicDate = customerCalcBasicDate;
        this.customerCalcAverageWorkerCount = customerCalcAverageWorkerCount;
    }

    public void update(CustomerUpdateDto.ContentClass customer) {
        this.customerCode = customer.getCustomerCode();
        this.customerCompanyCode = customer.getCustomerCompanyCode();
        this.customerMuserId = customer.getCustomerMuserId();
        this.customerMuserMemo = customer.getCustomerMuserMemo();
        this.customerCreateName = customer.getCustomerCreateName();
        this.customerCreateRoute = customer.getCustomerCreateRoute();
        this.customerDepositDate = customer.getCustomerDepositDate();
        this.customerBillBoolean = customer.getCustomerBillBoolean();
        this.customerName = customer.getCustomerName();
        this.customerPassword = customer.getCustomerPassword();
        this.customerAddress = customer.getCustomerAddress();
        this.customerAddressDetail = customer.getCustomerAddressDetail();
        this.customerStatus = customer.getCustomerStatus();
        this.customerTel = customer.getCustomerTel();
        this.customerInsuranceCost = customer.getCustomerInsuranceCost();
        this.customerSetCost = customer.getCustomerSetCost();
        this.customerManageCost = customer.getCustomerManageCost();
        this.customerOwnerName = customer.getCustomerOwnerName();
        this.customerFourInsuranceName = customer.getCustomerFourInsuranceName();
        this.customerMainType = customer.getCustomerMainType();
        this.customerSubType = customer.getCustomerSubType();
        this.customerSupportFee = customer.getCustomerSupportFee();
        this.customerMemo = customer.getCustomerMemo();
        this.customerDeleteStatus = customer.getCustomerDeleteStatus();
        this.customerGwanriNo = customer.getCustomerGwanriNo();
        this.customerInsuranceDivision = customer.getCustomerInsuranceDivision();
        this.customerScaleStatus = customer.getCustomerScaleStatus();
        this.customerSamusuimStatus = customer.getCustomerSamusuimStatus();
        this.customerSungribStatus = customer.getCustomerSungribStatus();
        this.customerCalcBasicDate = customer.getCustomerCalcBasicDate();
        this.customerCalcAverageWorkerCount = customer.getCustomerCalcAverageWorkerCount();
    }

    public void managementEnd () {
        this.customerDeleteStatus = 1;
    }

    public void restore() {
        this.customerDeleteStatus = 0;
    }

}
