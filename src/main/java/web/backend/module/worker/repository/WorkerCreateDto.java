package web.backend.module.worker.repository;

import lombok.Data;
import web.backend.module.customer.repository.CustomerCreateDto;

import java.time.LocalDateTime;

@Data
public class WorkerCreateDto {

    private Integer workerIndex;
    private String workerMuserId;
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
    private String workerWageTerm;
    private String workerWageDate;
    private String workerInsuranceMemo;
    private String workerEmployType;
    private String workerStartDate;
    private String workerEndDate;
    private String workerMemo;
    private String workerAddress;
    private String workerAddressDetail;
    private String workerWorkType;
    private String workerWorkTypeDetail;
    private String workerPayType;
    private String workerPay;
    private String workerRefreshType;
    private String workerMonthlyRefreshCount;
    private String workerWeeklyWorkCount;
    private String workerWeeklyRefreshCount;
    private String workerStartTime;
    private String workerEndTime;
    private String workerRefreshDailyHour;
    private String workerRefreshNightHour;
    private String workerGeunrojaRegNum1;
    private String workerGeunrojaRegNum2;
    private String workerChideukCost;
    private int workerAvgWorkerCount;
    private String workerStandardYear;
    private int workerSingoStatus;
    private int workerChwideukStatus;
    private int workerSangsilStatus;
    private int workerJungjungStatus;
    private String workerRefreshDailyMinute;
    private String workerRefreshNightMinute;

    private WorkerWeeklyDataVo workerWeeklyData;
    private WorkerWeeklyPayDataVo workerWeeklyPayData;
    private CustomerCreateDto workerCustomerData;

    private String workerWageTerm1;
    private String workerWageTerm2;
    private String workerWageTerm3;
    private String workerWageTerm4;

    private String workerWageDate1;
    private String workerWageDate2;
}
