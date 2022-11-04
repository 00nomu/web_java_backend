package mobile.backend.module.customer.repository;

import mobile.backend.module.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerSpringDataJpaRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByCustomerIndex(int id);

    Optional<Customer> findByCustomerCode(String code);

    Optional<Customer> findByCustomerCodeAndCustomerCompanyCode(String customerCode, String customerCompanyCode);

    void deleteByCustomerIndex(Integer id);

    void deleteByCustomerCode(String id);
}
