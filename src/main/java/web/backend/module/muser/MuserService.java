package web.backend.module.muser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.backend.module.common.repository.CommonCheckboxListDto;
import web.backend.exception.CustomRuntimeException;
import web.backend.module.muser.repository.MuserCreateDto;
import web.backend.module.muser.repository.MuserQueryRepository;
import web.backend.module.muser.repository.MuserSpringDataJpaRepository;
import web.backend.module.muser.repository.MuserUpdateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MuserService {

    private final MuserQueryRepository queryRepository;
    private final MuserSpringDataJpaRepository springDataJpaRepository;

    public List<Muser> findAll() {
        return springDataJpaRepository.findAll();
    }

    public Muser findByIndex(Integer id) {
        return springDataJpaRepository.findByMuserIndex(id).get();
    }

    public String save(MuserCreateDto createDto) {
        Optional<Muser> muserOne = springDataJpaRepository.findByMuserId(createDto.getMuserId());

        if (muserOne.isEmpty()) {
            Muser muser = new Muser(
                    createDto.getMuserId(),
                    createDto.getMuserPassword(),
                    createDto.getMuserMobileSignup(),
                    createDto.getMuserPoint(),
                    createDto.getMuserName(),
                    createDto.getMuserTel(),
                    createDto.getMuserPaymentsType(),
                    createDto.getMuserWorkerLimit()
            );
            springDataJpaRepository.save(muser);
            return "ok";
        }
        else {
            throw new CustomRuntimeException("duple");
        }
    }

    public String update(MuserUpdateDto updateDto) {
        Optional<Muser> muserOne = springDataJpaRepository.findByMuserId(updateDto.getContent().getMuserId());
        if(!muserOne.isEmpty()) {
            if(!Objects.equals(updateDto.getContent().getMuserId(), updateDto.getWhere().getMuserId())) {
                throw new CustomRuntimeException("duple");
            }
        }
        Optional<Muser> findOne = springDataJpaRepository.findByMuserId(updateDto.getWhere().getMuserId());
        findOne.get().update(updateDto.getContent());
        return "ok";
    }

    public String delete(CommonCheckboxListDto checkboxListDto) {
        for(String id : checkboxListDto.getCheckboxList()) {
            springDataJpaRepository.deleteByMuserId(id);
        }
        return "ok";
    }


}
