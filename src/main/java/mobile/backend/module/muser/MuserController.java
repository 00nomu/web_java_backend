package mobile.backend.module.muser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mobile.backend.module.common.repository.CommonCheckboxListDto;
import mobile.backend.module.muser.repository.MuserCreateDto;
import mobile.backend.module.muser.repository.MuserUpdateDto;
import mobile.backend.response.CommonResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/muser")
public class MuserController {

    private final MuserService service;

    @GetMapping
    public CommonResponse<List<Muser>> findAll() {
        return new CommonResponse<List<Muser>>(true, service.findAll());
    }

    @GetMapping("/{id}")
    public CommonResponse<Muser> findByIndex(@PathVariable(value = "id") int id ) {
        return new CommonResponse<>(true, service.findByIndex(id));
    }

    @PostMapping
    public CommonResponse<String> save(@RequestBody MuserCreateDto createDto) {
        return new CommonResponse<>(true, service.save(createDto));
    }

    @PatchMapping
    public CommonResponse<String> update(@RequestBody MuserUpdateDto updateDto) {
        return new CommonResponse<>(true, service.update(updateDto));
    }

    @DeleteMapping
    public CommonResponse<String> delete(@RequestBody CommonCheckboxListDto checkboxListDto) {
        return new CommonResponse<>(true, service.delete(checkboxListDto));
    }

}
