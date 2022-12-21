package web.backend.module.warrant;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.backend.module.common.repository.CommonCheckboxListDto;
import web.backend.module.warrant.repository.WarrantCreateDto;
import web.backend.module.warrant.repository.WarrantQueryRepository;
import web.backend.module.warrant.repository.WarrantSpringDataJpaRepository;
import web.backend.module.warrant.repository.WarrantUpdateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WarrantService {

    private final WarrantQueryRepository queryRepository;
    private final WarrantSpringDataJpaRepository springDataJpaRepository;

    public List<Warrant> findAll() {
        return springDataJpaRepository.findAll();
    }

    public Warrant findByIndex(Integer id) {
        return springDataJpaRepository.findByWarrantIndex(id).get();
    }

    public String save(WarrantCreateDto createDto) {
        Warrant warrant = new Warrant(
                createDto.getWarrantCompanyCode(),
                createDto.getWarrantOwnerName(),
                createDto.getWarrantRegNumber(),
                createDto.getWarrantCompanyName(),
                createDto.getWarrantCompanyAddress(),
                createDto.getWarrantCompanyTel(),
                createDto.getWarrantEmail(),
                createDto.getWarrantSign(),
                createDto.getWarrantSignPad(),
                createDto.getWarrantStampImage(),
                createDto.getWarrantSignDate(),
                createDto.getWarrantSendDate(),
                createDto.getWarrantCompanyType(),
                createDto.getWarrantManageCode(),
                createDto.getWarrantLookupStatus(),
                createDto.getWarrantSpecialPeopleBoolean(),
                createDto.getWarrantSpecialPeoples(),
                createDto.getWarrantSpecialPeopleResult(),
                createDto.getWarrantRefundBoolean(),
                createDto.getWarrantRefundAmount(),
                createDto.getWarrantMainType(),
                createDto.getWarrantCompanyAddressDetail(),
                createDto.getWarrantRegNumber2(),
                createDto.getWarrantContents()
        );
        springDataJpaRepository.save(warrant);
        return "ok";
    }

    public String update(WarrantUpdateDto updateDto) {
        Optional<Warrant> findOne = springDataJpaRepository.findByWarrantIndex(updateDto.getWhere().getWarrantIndex());
        findOne.get().update(updateDto.getContent());
        return "ok";
    }

    public String delete(CommonCheckboxListDto checkboxListDto) {
        for(String id : checkboxListDto.getCheckboxList()) {
            int warrantIndex = Integer.parseInt(id);
            springDataJpaRepository.deleteByWarrantIndex(warrantIndex);
        }
        return "ok";
    }

    public String lookupComplete(CommonCheckboxListDto checkboxListDto) {
        for(String id : checkboxListDto.getCheckboxList()) {
            int warrantIndex = Integer.parseInt(id);
            springDataJpaRepository.updateLookupComplete(warrantIndex);
        }
        return "ok";
    }
}
