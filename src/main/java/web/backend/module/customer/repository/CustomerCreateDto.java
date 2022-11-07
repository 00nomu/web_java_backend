package web.backend.module.customer.repository;

import lombok.Data;
import web.backend.module.worker.repository.WorkerCreateDto;

import java.util.List;

@Data
public class CustomerCreateDto {

    private String customerCode;
    private String customerCompanyCode;
    private String customerMuserId;
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
    private String customerMemo;
    private int customerDeleteStatus;
    private String customerGwanriNo;
    private String customerInsuranceDivision;
    private int customerScaleStatus;
    private int customerSamusuimStatus;
    private int customerSungribStatus;
    private String customerCalcBasicDate;
    private int customerCalcAverageWorkerCount;
    private String customerCalcWorkDay;
    private String customerCalcDayArray;

    private List<WorkerCreateDto> workerList;
}
