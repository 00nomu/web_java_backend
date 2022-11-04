package mobile.backend.module.customer.repository;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import mobile.backend.module.worker.repository.WorkerCreateDto;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // workerCreateDto
public class CustomerUpdateDto {
    public WhereClass where;
    public ContentClass content;

    @Getter
    public class WhereClass {
        public String CustomerCode;
    }

    @Getter
    public class ContentClass {
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
}
