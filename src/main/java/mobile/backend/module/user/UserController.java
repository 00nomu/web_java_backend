package mobile.backend.module.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mobile.backend.module.common.repository.CommonCheckboxListDto;
import mobile.backend.module.user.repository.UserCreateDto;
import mobile.backend.module.user.repository.UserUpdateDto;
import mobile.backend.response.CommonResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @GetMapping
    public CommonResponse<List<User>> findAll() {
        return new CommonResponse<>(true, service.findAll());
    }

    @GetMapping("/{id}")
    public CommonResponse<User> findByIndex(@PathVariable(value = "id") int id) {
        return new CommonResponse<>(true, service.findByIndex(id));
    }

    @PostMapping
    public CommonResponse<String> save(@RequestBody UserCreateDto createDto) {
        return new CommonResponse<>(true, service.save(createDto));
    }

    @PatchMapping
    public CommonResponse<String> update(@RequestBody UserUpdateDto updateDto) {
        return new CommonResponse<>(true, service.update(updateDto));
    }

    @DeleteMapping
    public CommonResponse<String> delete(@RequestBody CommonCheckboxListDto checkboxListDto) {
        return new CommonResponse<>(true, service.delete(checkboxListDto));
    }
}
