package web.backend.module.customer.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@Slf4j
public class CustomerQueryRepository {
    private final JPAQueryFactory query;

    public CustomerQueryRepository(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

}
