package mobile.backend.module.common.repository;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.EntityPathBase;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Objects;

import static mobile.backend.module.company.QCompany.company;
import static mobile.backend.module.customer.QCustomer.customer;
import static mobile.backend.module.muser.QMuser.muser;
import static mobile.backend.module.user.QUser.user;
import static mobile.backend.module.warrant.QWarrant.warrant;

@Slf4j
public class CommonQueryMethod {

    public EntityPathBase<?> selectMethod(CommonDataListDto dataListDto) {
        switch (dataListDto.getComponentTitle()) {
            case "customer":
                return customer;
            case "company":
                return company;
            case "mobileUser":
                return muser;
            case "webUser":
                return user;
            case "warrant":
                return warrant;
        }
        return null;
    }

    public EntityPathBase<?> fromMethod(CommonDataListDto dataListDto) {
        switch (dataListDto.getComponentTitle()) {
            case "customer":
                return customer;
            case "company":
                return company;
            case "mobileUser":
                return muser;
            case "webUser":
                return user;
            case "warrant":
                return warrant;
        }
        return null;
    }

    public BooleanExpression equalMethod(CommonDataListDto dataListDto) {
        switch (dataListDto.getComponentTitle()) {
            case "customer":
                return customer.customerDeleteStatus.eq(dataListDto.getBodyNumber() == 0 ? 0 : 1);
            case "warrant":
                BooleanExpression ex = warrant.warrantCompanyCode.eq(dataListDto.getCompanyCode());
                if (Objects.equals(dataListDto.getCompanyCode(), "7828500389")) {
                    return warrant.warrantLookupStatus.eq(dataListDto.getBodyNumber() == 0 ? 0 : 1);
                } else {
                    return warrant.warrantLookupStatus.eq(dataListDto.getBodyNumber() == 0 ? 0 : 1).and(ex);
                }
            default:
                return null;
        }
    }

    public BooleanExpression betweenMethod(CommonDataListDto dataListDto) {
        switch (dataListDto.getComponentTitle()) {
            case "customer":
                return customer.customerCreated.between(dataListDto.getStartDate(), dataListDto.getEndDate());
            case "company":
                return company.companyCreated.between(dataListDto.getStartDate(), dataListDto.getEndDate());
            case "mobileUser":
                return muser.muserCreated.between(dataListDto.getStartDate(), dataListDto.getEndDate());
            case "webUser":
                return user.userCreated.between(dataListDto.getStartDate(), dataListDto.getEndDate());
            case "warrant":
                return warrant.warrantCreated.between(dataListDto.getStartDate(), dataListDto.getEndDate());
            default:
                return null;
        }
    }

    public BooleanExpression likeMethod(CommonDataListDto dataListDto) {

        String searchSelectBox = dataListDto.getSearchSelectBox();
        String searchText = "%" + dataListDto.getSearchText() + "%";

        switch (dataListDto.getComponentTitle()) {
            case "customer":
                switch (searchSelectBox) {
                    case "customer_name":
                        return customer.customerName.like(searchText);
                    case "customer_address":
                        return customer.customerAddress.like(searchText);
                    case "customer_four_insurance_name":
                        return customer.customerFourInsuranceName.like(searchText);
                    case "customer_muser_id":
                        return customer.customerMuserId.like(searchText);
                    default:
                        return customer.customerName.like(searchText)
                                .or(customer.customerAddress.like(searchText)
                                        .or(customer.customerFourInsuranceName.like(searchText)
                                                .or(customer.customerMuserId.like(searchText))));
                }
            case "company":
                switch (searchSelectBox) {
                    case "company_code":
                        return company.companyCode.like(searchText);
                    case "company_name":
                        return company.companyName.like(searchText);
                    case "company_tel":
                        return company.companyTel.like(searchText);
                    case "company_owner_name":
                        return company.companyOwnerName.like(searchText);
                    case "company_memo":
                        return company.companyMemo.like(searchText);
                    default:
                        return company.companyCode.like(searchText)
                                .or(company.companyName.like(searchText)
                                        .or(company.companyTel.like(searchText)
                                                .or(company.companyOwnerName.like(searchText)
                                                        .or(company.companyMemo.like(searchText)))));
                }
            case "mobileUser":
                switch (searchSelectBox) {
                    case "muser_name":
                        return muser.muserName.like(searchText);
                    case "muser_id":
                        return muser.muserId.like(searchText);
                    default:
                        return muser.muserName.like(searchText)
                                .or(muser.muserId.like(searchText));
                }
            case "webUser":
                switch (searchSelectBox) {
                    case "user_name":
                        return user.userName.like(searchText);
                    case "user_id":
                        return user.userId.like(searchText);
                    case "user_company_code":
                        return user.userCompanyCode.like(searchText);
                    default:
                        return user.userName.like(searchText)
                                .or(user.userId.like(searchText)
                                        .or(user.userCompanyCode.like(searchText)));
                }
            case "warrant":
                switch (searchSelectBox) {
                    case "warrant_company_name":
                        return warrant.warrantCompanyName.like(searchText);
                    case "warrant_owner_name":
                        return warrant.warrantOwnerName.like(searchText);
                    case "warrant_main_type":
                        return warrant.warrantMainType.like(searchText);
                    default:
                        return warrant.warrantCompanyName.like(searchText)
                                .or(warrant.warrantOwnerName.like(searchText)
                                        .or(warrant.warrantMainType.like(searchText)
                                                .or(warrant.warrantCompanyCode.like(searchText)
                                                        )));
                }
            default:
                return null;
        }

    }

    public OrderSpecifier<LocalDateTime> orderByMethod(CommonDataListDto dataListDto) {
        switch (dataListDto.getComponentTitle()) {
            case "customer":
                return customer.customerCreated.desc();
            case "company":
                return company.companyCreated.desc();
            case "mobileUser":
                return muser.muserCreated.desc();
            case "webUser":
                return user.userCreated.desc();
            case "warrant":
                return warrant.warrantCreated.desc();
            default:
                return null;
        }
    }
}
