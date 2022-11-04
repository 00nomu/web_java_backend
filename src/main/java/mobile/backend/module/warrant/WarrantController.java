package mobile.backend.module.warrant;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mobile.backend.module.common.repository.CommonCheckboxListDto;
import mobile.backend.module.common.repository.CommonDataListDto;
import mobile.backend.module.warrant.repository.WarrantCreateDto;
import mobile.backend.module.warrant.repository.WarrantUpdateDto;
import mobile.backend.response.CommonResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/warrant")
public class WarrantController {

    private final WarrantService service;

    @GetMapping
    public CommonResponse<List<Warrant>> findAll() {
        return new CommonResponse<List<Warrant>>(true, service.findAll());
    }

    @GetMapping("/{id}")
    public CommonResponse<Warrant> findByIndex(@PathVariable(value = "id") int id) {
        return new CommonResponse<Warrant>(true, service.findByIndex(id));
    }

    @PostMapping
    public CommonResponse<String> save(@RequestBody WarrantCreateDto createDto) {
        return new CommonResponse<String>(true, service.save(createDto));
    }

    @PatchMapping
    public CommonResponse<String> update(@RequestBody WarrantUpdateDto updateDto) {
        return new CommonResponse<>(true, service.update(updateDto));
    }

    @DeleteMapping
    public CommonResponse<String> delete(@RequestBody CommonCheckboxListDto checkboxListDto) {
        return new CommonResponse<String>(true, service.delete(checkboxListDto));
    }

    @DeleteMapping("/lookupcomplete")
    public CommonResponse<String> lookupComplete(@RequestBody CommonCheckboxListDto checkboxListDto) {
        return new CommonResponse<String>(true, service.lookupComplete(checkboxListDto));
    }

}
