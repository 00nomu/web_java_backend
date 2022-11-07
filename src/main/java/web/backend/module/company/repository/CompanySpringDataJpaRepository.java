package web.backend.module.company.repository;

import web.backend.module.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanySpringDataJpaRepository extends JpaRepository<Company, Integer> {

    Optional<Company> findByCompanyIndex(int id);
    Optional<Company> findByCompanyCode(String companyCode);

    void deleteByCompanyCode(String companyId);
}
