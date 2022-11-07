package web.backend.module.worker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mobile.backend.module.worker.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.backend.module.worker.repository.WorkerCreateDto;
import web.backend.module.worker.repository.WorkerQueryRepository;
import web.backend.module.worker.repository.WorkerSpringDataJpaRepository;
import web.backend.module.worker.repository.WorkerUpdateDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WorkerService {

    private final WorkerQueryRepository queryRepository;
    private final WorkerSpringDataJpaRepository springDataJpaRepository;

    public Worker findByIndex(Integer id) {
        return springDataJpaRepository.findByWorkerIndex(id).get();
    }

    public List<Worker> findAllByIndex(String workerCustomerCode) {
        return springDataJpaRepository.findAllByWorkerCustomerCode(workerCustomerCode);
    }

    public String save(WorkerCreateDto createDto) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        Worker worker = new Worker(
                createDto.getWorkerMuserId(),
                createDto.getWorkerMuserMemo(),
                createDto.getWorkerPrivacy(),
                createDto.getWorkerCodeNumber(),
                createDto.getWorkerBirthday(),
                createDto.getWorkerCustomerCode(),
                createDto.getWorkerName(),
                createDto.getWorkerGetDate(),
                createDto.getWorkerLostDate(),
                createDto.getWorkerNationalPension(),
                createDto.getWorkerHealthInsurance(),
                createDto.getWorkerEmploymentInsurance(),
                createDto.getWorkerLongcareInsurance(),
                createDto.getWorkerIncomeTax(),
                createDto.getWorkerResidentTax(),
                createDto.getWorkerTel(),
                createDto.getWorkerWageTerm(),
                createDto.getWorkerWageDate(),
                createDto.getWorkerInsuranceMemo(),
                createDto.getWorkerEmployType(),
                createDto.getWorkerStartDate(),
                createDto.getWorkerEndDate(),
                createDto.getWorkerMemo(),
                createDto.getWorkerAddress(),
                createDto.getWorkerAddressDetail(),
                mapper.writeValueAsString(createDto.getWorkerWeeklyData()),
                createDto.getWorkerWorkType(),
                createDto.getWorkerWorkTypeDetail(),
                createDto.getWorkerPayType(),
                createDto.getWorkerPay(),
                createDto.getWorkerRefreshType(),
                createDto.getWorkerMonthlyRefreshCount(),
                createDto.getWorkerWeeklyWorkCount(),
                createDto.getWorkerStartTime(),
                createDto.getWorkerEndTime(),
                createDto.getWorkerRefreshDailyHour(),
                createDto.getWorkerRefreshNightHour(),
                createDto.getWorkerGeunrojaRegNum1(),
                createDto.getWorkerGeunrojaRegNum2(),
                createDto.getWorkerChideukCost(),
                createDto.getWorkerAvgWorkerCount(),
                mapper.writeValueAsString(createDto.getWorkerWeeklyPayData()),
                createDto.getWorkerStandardYear(),
                createDto.getWorkerSingoStatus(),
                createDto.getWorkerChwideukStatus(),
                createDto.getWorkerSangsilStatus(),
                createDto.getWorkerJungjungStatus(),
                mapper.writeValueAsString(createDto.getWorkerCustomerData()),
                createDto.getWorkerRefreshDailyMinute(),
                createDto.getWorkerRefreshNightMinute()
        );
        springDataJpaRepository.save(worker);
        return "ok";
    }

    public String update(WorkerUpdateDto updateDto) throws JsonProcessingException {
        Optional<Worker> findOne = springDataJpaRepository.findByWorkerIndex(updateDto.getWhere().getWorkerIndex());

        // 기존에 없던 근로자들은 새로 추가
        if(findOne.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper();
            Worker worker = new Worker(
                    updateDto.getContent().getWorkerMuserId(),
                    updateDto.getContent().getWorkerMuserMemo(),
                    updateDto.getContent().getWorkerPrivacy(),
                    updateDto.getContent().getWorkerCodeNumber(),
                    updateDto.getContent().getWorkerBirthday(),
                    updateDto.getContent().getWorkerCustomerCode(),
                    updateDto.getContent().getWorkerName(),
                    updateDto.getContent().getWorkerGetDate(),
                    updateDto.getContent().getWorkerLostDate(),
                    updateDto.getContent().getWorkerNationalPension(),
                    updateDto.getContent().getWorkerHealthInsurance(),
                    updateDto.getContent().getWorkerEmploymentInsurance(),
                    updateDto.getContent().getWorkerLongcareInsurance(),
                    updateDto.getContent().getWorkerIncomeTax(),
                    updateDto.getContent().getWorkerResidentTax(),
                    updateDto.getContent().getWorkerTel(),
                    updateDto.getContent().getWorkerWageTerm(),
                    updateDto.getContent().getWorkerWageDate(),
                    updateDto.getContent().getWorkerInsuranceMemo(),
                    updateDto.getContent().getWorkerEmployType(),
                    updateDto.getContent().getWorkerStartDate(),
                    updateDto.getContent().getWorkerEndDate(),
                    updateDto.getContent().getWorkerMemo(),
                    updateDto.getContent().getWorkerAddress(),
                    updateDto.getContent().getWorkerAddressDetail(),
                    mapper.writeValueAsString(updateDto.getContent().getWorkerWeeklyData()),
                    updateDto.getContent().getWorkerWorkType(),
                    updateDto.getContent().getWorkerWorkTypeDetail(),
                    updateDto.getContent().getWorkerPayType(),
                    updateDto.getContent().getWorkerPay(),
                    updateDto.getContent().getWorkerRefreshType(),
                    updateDto.getContent().getWorkerMonthlyRefreshCount(),
                    updateDto.getContent().getWorkerWeeklyWorkCount(),
                    updateDto.getContent().getWorkerStartTime(),
                    updateDto.getContent().getWorkerEndTime(),
                    updateDto.getContent().getWorkerRefreshDailyHour(),
                    updateDto.getContent().getWorkerRefreshNightHour(),
                    updateDto.getContent().getWorkerGeunrojaRegNum1(),
                    updateDto.getContent().getWorkerGeunrojaRegNum2(),
                    updateDto.getContent().getWorkerChideukCost(),
                    updateDto.getContent().getWorkerAvgWorkerCount(),
                    mapper.writeValueAsString(updateDto.getContent().getWorkerWeeklyPayData()),
                    updateDto.getContent().getWorkerStandardYear(),
                    updateDto.getContent().getWorkerSingoStatus(),
                    updateDto.getContent().getWorkerChwideukStatus(),
                    updateDto.getContent().getWorkerSangsilStatus(),
                    updateDto.getContent().getWorkerJungjungStatus(),
                    mapper.writeValueAsString(updateDto.getContent().getWorkerCustomerData()),
                    updateDto.getContent().getWorkerRefreshDailyMinute(),
                    updateDto.getContent().getWorkerRefreshNightMinute()
            );
            springDataJpaRepository.save(worker);
        }
        // 기존 근로자들은 데이터 바꿔줌
        else {
            findOne.get().update(updateDto.getContent());
        }
        return "ok";
    }

    public String delete(Integer id) {
        springDataJpaRepository.deleteById(id);
        return "ok";
    }
}
