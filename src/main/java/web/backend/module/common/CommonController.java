package web.backend.module.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.backend.module.common.repository.CommonDataListDto;
import web.backend.response.CommonListResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/common")
public class CommonController {

    private final CommonService service;

    @PostMapping("/list")
    public CommonListResponse<List<?>> list(@RequestBody CommonDataListDto dataListDto) {
        List<?> list = service.list(dataListDto);
        long totalCount = service.totalCount(dataListDto);
        return new CommonListResponse<>(true, list, list.size(), totalCount);
    }
}
