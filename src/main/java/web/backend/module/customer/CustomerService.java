package web.backend.module.customer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.backend.exception.CustomRuntimeException;
import web.backend.module.common.repository.CommonCheckboxListDto;
import web.backend.module.customer.repository.CustomerCreateDto;
import web.backend.module.customer.repository.CustomerQueryRepository;
import web.backend.module.customer.repository.CustomerSpringDataJpaRepository;
import web.backend.module.customer.repository.CustomerUpdateDto;
import web.backend.module.worker.WorkerService;
import web.backend.module.worker.repository.WorkerCreateDto;
import web.backend.module.worker.repository.WorkerUpdateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CustomerService {

    private final CustomerQueryRepository queryRepository;
    private final CustomerSpringDataJpaRepository springDataJpaRepository;
    private final WorkerService workerService;

    public List<Customer> findAll() {
        return springDataJpaRepository.findAll();
    }

    public Customer findByIndex(Integer id) {
        return springDataJpaRepository.findByCustomerIndex(id).get();
    }

    public String save(CustomerCreateDto createDto) throws JsonProcessingException {
        Optional<Customer> customerOne = springDataJpaRepository.findByCustomerCode(createDto.getCustomerCode());
        if (customerOne.isEmpty()) {
            Customer customer = new Customer(
                    createDto.getCustomerCode(),
                    createDto.getCustomerCompanyCode(),
                    createDto.getCustomerMuserId(),
                    createDto.getCustomerMuserMemo(),
                    createDto.getCustomerCreateName(),
                    createDto.getCustomerCreateRoute(),
                    createDto.getCustomerDepositDate(),
                    createDto.getCustomerBillBoolean(),
                    createDto.getCustomerName(),
                    createDto.getCustomerPassword(),
                    createDto.getCustomerAddress(),
                    createDto.getCustomerAddressDetail(),
                    createDto.getCustomerStatus(),
                    createDto.getCustomerTel(),
                    createDto.getCustomerInsuranceCost(),
                    createDto.getCustomerSetCost(),
                    createDto.getCustomerManageCost(),
                    createDto.getCustomerOwnerName(),
                    createDto.getCustomerFourInsuranceName(),
                    createDto.getCustomerMainType(),
                    createDto.getCustomerSubType(),
                    createDto.getCustomerSupportFee(),
                    createDto.getCustomerMemo(),
                    createDto.getCustomerDeleteStatus(),
                    createDto.getCustomerGwanriNo(),
                    createDto.getCustomerInsuranceDivision(),
                    createDto.getCustomerScaleStatus(),
                    createDto.getCustomerSamusuimStatus(),
                    createDto.getCustomerSungribStatus(),
                    createDto.getCustomerCalcBasicDate(),
                    createDto.getCustomerCalcAverageWorkerCount()
            );
            workerCreateMethod(createDto);
            springDataJpaRepository.save(customer);

            return "ok";
        } else {
            throw new CustomRuntimeException("duple");
        }
    }

    public String update(CustomerUpdateDto updateDto) throws JsonProcessingException {
        Optional<Customer> customerOne = springDataJpaRepository.findByCustomerCode(updateDto.getContent().getCustomerCode());
        if(!customerOne.isEmpty()) {
            if(!Objects.equals(updateDto.getContent().getCustomerCode(), updateDto.getWhere().getCustomerCode())) {
                throw new CustomRuntimeException("duple");
            }
        }

        workerUpdateMethod(updateDto);


        Optional<Customer> findOne = springDataJpaRepository.findByCustomerCode(updateDto.getWhere().getCustomerCode());
        findOne.ifPresent(customer -> customer.update(updateDto.getContent()));
        return "ok";
    }

    public String managementEnd(CommonCheckboxListDto checkboxListDto) {
        for (String id : checkboxListDto.getCheckboxList()) {
            Optional<Customer> customerOne = springDataJpaRepository.findByCustomerCode(id);
            customerOne.ifPresent(Customer::managementEnd);
        }
        return "ok";
    }

    public String restore(CommonCheckboxListDto checkboxListDto) {
        for (String id : checkboxListDto.getCheckboxList()) {
            Optional<Customer> customerOne = springDataJpaRepository.findByCustomerCode(id);
            customerOne.ifPresent(Customer::restore);
        }
        return "ok";
    }

    public String delete(CommonCheckboxListDto checkboxListDto) {
        for (String id : checkboxListDto.getCheckboxList()) {
            springDataJpaRepository.deleteByCustomerCode(id);
        }
        return "ok";
    }

    public Customer findOne(String customerCode, String customerCompanyCode) {
        Optional<Customer> customerOne = springDataJpaRepository.findByCustomerCodeAndCustomerCompanyCode(customerCode, customerCompanyCode);

        if (customerOne.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return customerOne.get();
        }
    }


    private void workerCreateMethod(CustomerCreateDto createDto) throws JsonProcessingException {
        if (createDto.getWorkerList().size() > 0) {
            for (int i = 0; i < createDto.getWorkerList().size(); i++) {
                WorkerCreateDto workerCreateDto = createDto.getWorkerList().get(i);

                workerCreateDto.setWorkerCustomerCode(createDto.getCustomerCode());
                workerCreateDto.setWorkerMuserId(createDto.getCustomerMuserId());

                workerCreateDto.setWorkerWageTerm(termList(
                        workerCreateDto.getWorkerWageTerm1(),
                        workerCreateDto.getWorkerWageTerm2(),
                        workerCreateDto.getWorkerWageTerm3(),
                        workerCreateDto.getWorkerWageTerm4()
                ));

                workerCreateDto.setWorkerWageDate(dateList(
                        workerCreateDto.getWorkerWageDate1(),
                        workerCreateDto.getWorkerWageDate2()
                ));

                workerService.save(workerCreateDto);
            }
        }
    }

    private void workerUpdateMethod(CustomerUpdateDto updateDto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        if (updateDto.getContent().getWorkerList().size() > 0) {
            for (int i = 0; i < updateDto.getContent().getWorkerList().size(); i++) {
                WorkerUpdateDto workerUpdateDto = new WorkerUpdateDto(
                        new WorkerUpdateDto.WhereClass(updateDto.getContent().getWorkerList().get(i).getWorkerIndex()),
                        new WorkerUpdateDto.ContentClass(
                                updateDto.getContent().getWorkerList().get(i).getWorkerIndex(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerMuserId(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerMuserMemo(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerPrivacy(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerCodeNumber(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerBirthday(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerCustomerCode(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerName(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerGetDate(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerLostDate(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerNationalPension(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerHealthInsurance(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerEmploymentInsurance(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerLongcareInsurance(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerIncomeTax(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerResidentTax(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerTel(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerWageTerm(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerWageDate(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerInsuranceMemo(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerEmployType(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerStartDate(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerEndDate(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerMemo(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerAddress(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerAddressDetail(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerWorkType(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerWorkTypeDetail(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerPayType(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerPay(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerRefreshType(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerMonthlyRefreshCount(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerWeeklyWorkCount(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerStartTime(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerEndTime(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerRefreshDailyHour(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerRefreshNightHour(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerGeunrojaRegNum1(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerGeunrojaRegNum2(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerChideukCost(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerAvgWorkerCount(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerStandardYear(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerSingoStatus(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerChwideukStatus(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerSangsilStatus(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerJungjungStatus(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerRefreshDailyMinute(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerRefreshNightMinute(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerWeeklyData(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerWeeklyPayData(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerCustomerData(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerWageTerm1(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerWageTerm2(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerWageTerm3(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerWageTerm4(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerWageDate1(),
                                updateDto.getContent().getWorkerList().get(i).getWorkerWageDate2()
                        )
                );
                workerUpdateDto.getContent().setWorkerCustomerCode(updateDto.getContent().getCustomerCode());
                workerUpdateDto.getContent().setWorkerMuserId(updateDto.getContent().getCustomerMuserId());


                workerUpdateDto.getContent().setWorkerWageTerm(termList(
                        workerUpdateDto.getContent().getWorkerWageTerm1(),
                        workerUpdateDto.getContent().getWorkerWageTerm2(),
                        workerUpdateDto.getContent().getWorkerWageTerm3(),
                        workerUpdateDto.getContent().getWorkerWageTerm4()
                ));

                workerUpdateDto.getContent().setWorkerWageDate(dateList(
                        workerUpdateDto.getContent().getWorkerWageDate1(),
                        workerUpdateDto.getContent().getWorkerWageDate2()
                ));

                workerService.update(workerUpdateDto);
            }
        }
    }

    private String termList(
            String term1,
            String term2,
            String term3,
            String term4

    ) {
        List<String> termList = new ArrayList<>();
        termList.add("\"" + term1 + "\"");
        termList.add("\"" + term2 + "\"");
        termList.add("\"" + term3 + "\"");
        termList.add("\"" + term4 + "\"");
        return termList.toString();
    }

    private String dateList(
            String date1,
            String date2
    ) {
        List<String> dateList = new ArrayList<>();
        dateList.add("\"" + date1 + "\"");
        dateList.add("\"" + date2 + "\"");
        return dateList.toString();
    }

}
