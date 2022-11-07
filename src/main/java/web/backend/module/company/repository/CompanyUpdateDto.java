package web.backend.module.company.repository;

import lombok.Data;
import lombok.Getter;
import web.backend.module.company.Company;

@Data
public class CompanyUpdateDto {

    private WhereClass where;
    private ContentClass content;

    @Getter
    public class WhereClass {
        public String companyCode;
    }

    @Getter
    public class ContentClass extends Company {
        public String companyCode;
        public String companyName;
        public String companyTel;
        public String companyOwnerName;
        public String companyMemo;
    }
}
