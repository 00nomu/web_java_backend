package web.backend.module.user.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import web.backend.module.common.repository.CommonDataListDto;
import web.backend.module.common.repository.CommonQueryMethod;
import web.backend.module.company.Company;
import web.backend.module.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static mobile.backend.module.company.QCompany.company;
import static mobile.backend.module.user.QUser.user;

@Repository
@Slf4j
public class UserQueryRepository {

    private final JPAQueryFactory query;

    CommonQueryMethod method = new CommonQueryMethod();

    public UserQueryRepository(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    public List<UserListDto> list(CommonDataListDto dataListDto) {

        List<Tuple> fetch = query
                .select(user, company)
                .from(method.fromMethod(dataListDto))
                .leftJoin(company)
                .on(user.userCompanyCode.eq(company.companyCode))
                .where(
                        method.equalMethod(dataListDto),
                        method.betweenMethod(dataListDto),
                        method.likeMethod(dataListDto)
                )
                .orderBy(method.orderByMethod(dataListDto))
                .offset((long) dataListDto.getPageNumber() * dataListDto.getPostNumber())
                .limit(dataListDto.getPostNumber())
                .fetch();

        List<UserListDto> list = new ArrayList<>();
        for (int i = 0; i < fetch.size(); i ++) {
            UserListDto userListDto = new UserListDto(fetch.get(i).get(0, User.class), fetch.get(i).get(1, Company.class));
            list.add(userListDto);
        }
        return list;
    }
}
