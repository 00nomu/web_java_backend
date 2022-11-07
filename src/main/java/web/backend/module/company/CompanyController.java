package web.backend.module.company;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.backend.module.common.repository.CommonCheckboxListDto;
import web.backend.module.common.repository.CommonDataListDto;
import web.backend.module.company.repository.CompanyCreateDto;
import web.backend.module.company.repository.CompanyUpdateDto;
import web.backend.response.CommonResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService service;

    @GetMapping
    public CommonResponse<List<Company>> findAll() {
        return new CommonResponse<>(true, service.findAll());
    }

    @GetMapping("/{id}")
    public CommonResponse<Company> findByIndex(@PathVariable(value = "id") int id) {
        return new CommonResponse<>(true, service.findByIndex(id));
    }

    @PostMapping
    public CommonResponse<String> save(@RequestBody CompanyCreateDto createDto) {
        return new CommonResponse<>(true, service.save(createDto));
    }

    @PatchMapping
    public CommonResponse<String> update(@RequestBody CompanyUpdateDto updateDto) {
        return new CommonResponse<>(true, service.update(updateDto));
    }

    @DeleteMapping
    public CommonResponse<String> delete( @RequestBody CommonCheckboxListDto checkboxListDto) {
        return new CommonResponse<>(true, service.delete(checkboxListDto));
    }

    @PostMapping("/list")
    public CommonResponse<List<Company>> list(@RequestBody CommonDataListDto dataListDto) {
        return new CommonResponse<>(true, service.list(dataListDto));
    }

}
