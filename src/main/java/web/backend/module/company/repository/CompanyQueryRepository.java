package web.backend.module.company.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import web.backend.module.common.repository.CommonDataListDto;
import web.backend.module.company.Company;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

import static web.backend.module.company.QCompany.company;

@Repository
@Slf4j
public class CompanyQueryRepository {
    private final JPAQueryFactory query;

    public CompanyQueryRepository(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    public List<Company> list(CommonDataListDto dataListDto) {

        return query
                .select(company)
                .from(company)
                .where(
                        company.companyCreated.between(dataListDto.getStartDate(), dataListDto.getEndDate()),
                        likeMethod(dataListDto.getSearchSelectBox(), dataListDto.getSearchText())
                )
                .orderBy(company.companyCreated.desc())
                .offset(dataListDto.getPageNumber() * dataListDto.getPostNumber())
                .limit(dataListDto.getPostNumber())
                .fetch();
    }

    private BooleanExpression likeMethod(String searchSelectBox, String text) {
        String searchText = "%"+text+"%";
        if (Objects.equals(searchSelectBox, "company_code")) {
            return company.companyCode.like(searchText);
        } else if (Objects.equals(searchSelectBox, "company_name")) {
            return company.companyName.like(searchText);
        } else if (Objects.equals(searchSelectBox, "company_tel")) {
            return company.companyTel.like(searchText);
        } else if (Objects.equals(searchSelectBox, "company_owner_name")) {
            return company.companyOwnerName.like(searchText);
        } else if (Objects.equals(searchSelectBox, "company_memo")) {
            return company.companyMemo.like(searchText);
        } else {
            return null;
        }

    }

}
