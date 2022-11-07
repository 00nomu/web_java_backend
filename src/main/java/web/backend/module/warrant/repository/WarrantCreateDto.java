package web.backend.module.warrant.repository;

import lombok.Data;

@Data
public class WarrantCreateDto {
    private String warrantCompanyCode;
    private String warrantOwnerName;
    private String warrantRegNumber;
    private String warrantCompanyName;
    private String warrantCompanyAddress;
    private String warrantCompanyTel;
    private String warrantEmail;
    private String warrantSign;
    private String warrantSignPad;
    private String warrantSignDate;
    private String warrantSendDate;
    private int warrantCompanyType;
    private String warrantManageCode;
    private int warrantLookupStatus;
    private int warrantSpecialPeopleBoolean;
    private String warrantSpecialPeoples;
    private String warrantSpecialPeopleResult;
    private int warrantRefundBoolean;
    private String warrantRefundAmount;
    private int warrantMainType;
    private String warrantCompanyAddressDetail;
    private String warrantRegNumber2;
    private String warrantContents;
}
