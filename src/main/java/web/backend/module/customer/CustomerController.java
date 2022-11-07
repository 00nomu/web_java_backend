package web.backend.module.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.backend.module.common.repository.CommonCheckboxListDto;
import web.backend.module.customer.repository.CustomerCreateDto;
import web.backend.module.customer.repository.CustomerUpdateDto;
import web.backend.response.CommonResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    public CommonResponse<List<Customer>> findAll() {
        return new CommonResponse<List<Customer>>(true, service.findAll());
    }

    @GetMapping("/{id}")
    public CommonResponse<Customer> findByIndex(@PathVariable(value = "id") int id) {
        return new CommonResponse<Customer>(true, service.findByIndex(id));
    }

    @PostMapping
    public CommonResponse<String> save(@RequestBody CustomerCreateDto createDto) throws JsonProcessingException  {
        return new CommonResponse<String>(true, service.save(createDto));
    }

    @PatchMapping
    public CommonResponse<String> update(@RequestBody CustomerUpdateDto updateDto) throws JsonProcessingException {
        return new CommonResponse<String>(true, service.update(updateDto));
    }

    @DeleteMapping
    public CommonResponse<String> delete(@RequestBody CommonCheckboxListDto checkboxListDto) {
        return new CommonResponse<String>(true, service.delete(checkboxListDto));
    }

    @DeleteMapping("/managementend")
    public CommonResponse<String> managementEnd(@RequestBody CommonCheckboxListDto checkboxListDto) {
        return new CommonResponse<String>(true, service.managementEnd(checkboxListDto));
    }

    @DeleteMapping("/restore")
    public CommonResponse<String> restore(@RequestBody CommonCheckboxListDto checkboxListDto) {
        return new CommonResponse<String>(true, service.restore(checkboxListDto));
    }

    @GetMapping("/find")
    public CommonResponse<Customer> findOne(@RequestParam("customer_code") String customerCode, @RequestParam("customer_company_code") String customerCompanyCode) {
        return new CommonResponse<Customer>(true, service.findOne(customerCode, customerCompanyCode));
    }

}
