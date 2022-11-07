package web.backend.module.worker;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.backend.module.worker.repository.WorkerCreateDto;
import web.backend.response.CommonResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerService service;

    @GetMapping("/{id}")
    public CommonResponse<Worker> findByIndex(@PathVariable(value = "id") int id) {
        return new CommonResponse<>(true, service.findByIndex(id));
    }

    @GetMapping("/findall")
    public CommonResponse<List<Worker>> findAll(@RequestParam("worker_customer_code") String workerCustomerCode ) {
        return new CommonResponse<>(true,service.findAllByIndex(workerCustomerCode));
    }

    @PostMapping
    public CommonResponse<String> save(@RequestBody WorkerCreateDto createDto) throws JsonProcessingException {
        return new CommonResponse<>(true, service.save(createDto));
    }


}
