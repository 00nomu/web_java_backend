package web.backend.module.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.backend.module.common.repository.CommonDataListDto;
import web.backend.module.common.repository.CommonQueryRepository;
import web.backend.module.user.repository.UserQueryRepository;
import web.backend.module.warrant.repository.WarrantQueryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CommonService {

    private final CommonQueryRepository queryRepository;
    private final WarrantQueryRepository warrantQueryRepository;
    private final UserQueryRepository userQueryRepository;


    public List<?> list(CommonDataListDto dataListDto) {
        switch(dataListDto.getComponentTitle()) {
            case "warrant": // 서브 쿼리 때문에 나눔
                return warrantQueryRepository.list(dataListDto);
            case "webUser": // left join 때문에 나눔
                return userQueryRepository.list(dataListDto);
            default:
                return queryRepository.list(dataListDto);
        }
    }

    public long totalCount(CommonDataListDto dataListDto) {
        return queryRepository.totalCount(dataListDto);
    }

}
