package mobile.backend.module.warrant.repository;

import lombok.Data;
import lombok.Getter;
import mobile.backend.module.warrant.Warrant;

@Data
public class WarrantUpdateDto {

    private WhereClass where;
    private ContentClass content;

    @Getter
    public class WhereClass {
        public int warrantIndex;
    }

    @Getter
    public class ContentClass extends Warrant {
        public String warrantCompanyCode;
        public String warrantOwnerName;
        public String warrantRegNumber;
        public String warrantCompanyName;
        public String warrantCompanyAddress;
        public String warrantCompanyTel;
        public String warrantEmail;
        public String warrantSign;
        public String warrantSignPad;
        public String warrantSignDate;
        public String warrantSendDate;
        public int warrantCompanyType;
        public String warrantManageCode;
        public int warrantLookupStatus;
        public int warrantSpecialPeopleBoolean;
        public String warrantSpecialPeoples;
        public String warrantSpecialPeopleResult;
        public int warrantRefundBoolean;
        public String warrantRefundAmount;
        public int warrantMainType;
        public String warrantCompanyAddressDetail;
        public String warrantRegNumber2;
        public String warrantContents;
    }
}
