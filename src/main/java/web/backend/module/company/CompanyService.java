package web.backend.module.company;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.backend.module.common.repository.CommonCheckboxListDto;
import web.backend.module.common.repository.CommonDataListDto;
import web.backend.exception.CustomRuntimeException;
import web.backend.module.company.repository.CompanyCreateDto;
import web.backend.module.company.repository.CompanyQueryRepository;
import web.backend.module.company.repository.CompanySpringDataJpaRepository;
import web.backend.module.company.repository.CompanyUpdateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CompanyService {

    private final CompanyQueryRepository queryRepository;
    private final CompanySpringDataJpaRepository springDataJpaRepository;

    public List<Company> findAll() {
        return springDataJpaRepository.findAll();
    }

    public Company findByIndex(Integer id) {
        return springDataJpaRepository.findByCompanyIndex(id).get();
    }

    public String save(CompanyCreateDto createDto) {
        Optional<Company> companyOne = springDataJpaRepository.findByCompanyCode(createDto.getCompanyCode());

        if(companyOne.isEmpty()) {
            Company company = new Company(
                    createDto.getCompanyCode(),
                    createDto.getCompanyName(),
                    createDto.getCompanyTel(),
                    createDto.getCompanyOwnerName(),
                    createDto.getCompanyMemo()
            );
            springDataJpaRepository.save(company);
            return "ok";
        }
        else {
            throw new CustomRuntimeException("duple");
        }
    }

    public String update(CompanyUpdateDto updateDto) {
        Optional<Company> companyOne = springDataJpaRepository.findByCompanyCode(updateDto.getContent().getCompanyCode());
        if(!companyOne.isEmpty()) {
            if(!Objects.equals(updateDto.getContent().getCompanyCode(), updateDto.getWhere().getCompanyCode())) {
                throw new CustomRuntimeException("duple");
            }
        }
        Optional<Company> findOne = springDataJpaRepository.findByCompanyCode(updateDto.getWhere().getCompanyCode());
        findOne.get().update(updateDto.getContent());
        return "ok";
    }

    public String delete(CommonCheckboxListDto checkboxListDto) {
        for(String id : checkboxListDto.getCheckboxList()) {
            springDataJpaRepository.deleteByCompanyCode(id);
        }
        return "ok";
    }

    public List<Company> list(CommonDataListDto dataListDto) {
        return queryRepository.list(dataListDto);
    }
}
