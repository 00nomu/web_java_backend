package mobile.backend.module.warrant.repository;

import lombok.Data;
import lombok.NoArgsConstructor;
import mobile.backend.module.company.Company;

@Data
@NoArgsConstructor
public class WarrantListDto {

    public WarrantListDto(WarrantListDto warrantListDto, Company company) {
        if (company != null) {
            this.companyName = company.getCompanyName();
        }

        this.warrantIndex = warrantListDto.getWarrantIndex();
        this.warrantCompanyCode = warrantListDto.getWarrantCompanyCode();
        this.warrantOwnerName = warrantListDto.getWarrantOwnerName();
        this.warrantRegNumber = warrantListDto.getWarrantRegNumber();
        this.warrantCompanyName = warrantListDto.getWarrantCompanyName();
        this.warrantCompanyAddress = warrantListDto.getWarrantCompanyAddress();
        this.warrantCompanyTel = warrantListDto.getWarrantCompanyTel();
        this.warrantEmail = warrantListDto.getWarrantEmail();
        this.warrantSign = warrantListDto.getWarrantSign();
        this.warrantSignPad = warrantListDto.getWarrantSignPad();
        this.warrantSignDate = warrantListDto.getWarrantSignDate();
        this.warrantSendDate = warrantListDto.getWarrantSendDate();
        this.warrantCompanyType = warrantListDto.getWarrantCompanyType();
        this.warrantManageCode = warrantListDto.getWarrantManageCode();
        this.warrantLookupStatus = warrantListDto.getWarrantLookupStatus();
        this.warrantSpecialPeopleBoolean = warrantListDto.getWarrantSpecialPeopleBoolean();
        this.warrantSpecialPeoples = warrantListDto.getWarrantSpecialPeoples();
        this.warrantSpecialPeopleResult = warrantListDto.getWarrantSpecialPeopleResult();
        this.warrantRefundBoolean = warrantListDto.getWarrantRefundBoolean();
        this.warrantRefundAmount = warrantListDto.getWarrantRefundAmount();
        this.warrantMainType = warrantListDto.getWarrantMainType();
        this.warrantCompanyAddressDetail = warrantListDto.getWarrantCompanyAddressDetail();
        this.warrantRegNumber2 = warrantListDto.getWarrantRegNumber2();
        this.warrantContents = warrantListDto.getWarrantContents();

        this.warrantStampName = warrantListDto.getWarrantStampName();
        this.warrantPersonalRegCardName = warrantListDto.getWarrantPersonalRegCardName();
        this.warrantBusinessRegCardName = warrantListDto.getWarrantBusinessRegCardName();
        this.warrantRefundResultName = warrantListDto.getWarrantRefundResultName();
        this.warrantRefundResultScanName = warrantListDto.getWarrantRefundResultScanName();
        this.warrantRefundCompleteName = warrantListDto.getWarrantRefundCompleteName();
        this.warrantContractDocName = warrantListDto.getWarrantContractDocName();
        this.warrantContractDocScanName = warrantListDto.getWarrantContractDocScanName();
        this.warrantCompleteName = warrantListDto.getWarrantCompleteName();

        this.warrantStampPath = warrantListDto.getWarrantStampPath();
        this.warrantPersonalRegCardPath = warrantListDto.getWarrantPersonalRegCardPath();
        this.warrantBusinessRegCardPath = warrantListDto.getWarrantBusinessRegCardPath();
        this.warrantRefundResultPath = warrantListDto.getWarrantRefundResultPath();
        this.warrantRefundResultScanPath = warrantListDto.getWarrantRefundResultScanPath();
        this.warrantRefundCompletePath = warrantListDto.getWarrantRefundCompletePath();
        this.warrantContractDocPath = warrantListDto.getWarrantContractDocPath();
        this.warrantContractDocScanPath = warrantListDto.getWarrantContractDocScanPath();
        this.warrantCompletePath = warrantListDto.getWarrantCompletePath();
    }

    private String companyName;

    private int warrantIndex;
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

    private String warrantStampName;
    private String warrantPersonalRegCardName;
    private String warrantBusinessRegCardName;
    private String warrantRefundResultName;
    private String warrantRefundResultScanName;
    private String warrantRefundCompleteName;
    private String warrantContractDocName;
    private String warrantContractDocScanName;
    private String warrantCompleteName;

    private String warrantStampPath;
    private String warrantPersonalRegCardPath;
    private String warrantBusinessRegCardPath;
    private String warrantRefundResultPath;
    private String warrantRefundResultScanPath;
    private String warrantRefundCompletePath;
    private String warrantContractDocPath;
    private String warrantContractDocScanPath;
    private String warrantCompletePath;

}
