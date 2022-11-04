package mobile.backend.module.common.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@Slf4j
public class CommonQueryRepository {

    private final JPAQueryFactory query;

    CommonQueryMethod method = new CommonQueryMethod();

    public CommonQueryRepository(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    public List<?> list(CommonDataListDto dataListDto) {

        return query
                .select(method.selectMethod(dataListDto))
                .from(method.fromMethod(dataListDto))
                .where(
                        method.equalMethod(dataListDto),
                        method.betweenMethod(dataListDto),
                        method.likeMethod(dataListDto)
                )
                .orderBy(method.orderByMethod(dataListDto))
                .offset((long) dataListDto.getPageNumber() * dataListDto.getPostNumber())
                .limit(dataListDto.getPostNumber())
                .fetch();
    }

    public long totalCount(CommonDataListDto dataListDto) {
        return query
                .select(method.selectMethod(dataListDto))
                .from(method.fromMethod(dataListDto))
                .where(
                        method.equalMethod(dataListDto),
                        method.betweenMethod(dataListDto),
                        method.likeMethod(dataListDto)
                ).stream().count();
    }
}