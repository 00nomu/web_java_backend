package mobile.backend.module.company.repository;

import lombok.Data;

@Data
public class CompanyCreateDto {

    private String companyCode;

    private String companyName;

    private String companyTel;

    private String companyOwnerName;

    private String companyMemo;
}
