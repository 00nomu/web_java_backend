package web.backend.module.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.backend.exception.CustomRuntimeException;
import web.backend.module.common.repository.CommonCheckboxListDto;
import web.backend.module.user.repository.UserCreateDto;
import web.backend.module.user.repository.UserQueryRepository;
import web.backend.module.user.repository.UserSpringDataJpaRepository;
import web.backend.module.user.repository.UserUpdateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {

    private final UserQueryRepository queryRepository;
    private final UserSpringDataJpaRepository springDataJpaRepository;

    public List<User> findAll() {
        return springDataJpaRepository.findAll();
    }

    public User findByIndex(Integer id) {
        return springDataJpaRepository.findByUserIndex(id).get();
    }

    public String save(UserCreateDto createDto) {
        Optional<User> userOne = springDataJpaRepository.findByUserId(createDto.getUserId());

        if (userOne.isEmpty()) {
            User user = new User(
                    createDto.getUserCompanyCode(),
                    createDto.getUserId(),
                    createDto.getUserPassword(),
                    createDto.getUserNumber(),
                    createDto.getUserName(),
                    createDto.getUserCreateName(),
                    createDto.getUserGrade(),
                    createDto.getUserAuth(),
                    createDto.getUserPhone(),
                    createDto.getAuthMenuCompany(),
                    createDto.getAuthMenuUserCustomer(),
                    createDto.getAuthMenuUserInfo(),
                    createDto.getAuthMenuMuserInfo(),
                    createDto.getAuthMenuWarrant(),
                    createDto.getUserNote(),
                    createDto.getUserDeleteStatus()
            );
            springDataJpaRepository.save(user);
            return "ok";
        }
        else {
            throw new CustomRuntimeException("duple");
        }
    }

    public String update(UserUpdateDto updateDto) {
        Optional<User> userOne = springDataJpaRepository.findByUserId(updateDto.getContent().getUserId());
        if(!userOne.isEmpty()) {
            if(!Objects.equals(updateDto.getContent().getUserId(), updateDto.getWhere().getUserId())) {
                throw new CustomRuntimeException("duple");
            }
        }
        Optional<User> findOne = springDataJpaRepository.findByUserId(updateDto.getWhere().getUserId());
        findOne.get().update(updateDto.getContent());
        return "ok";
    }

    public String delete(CommonCheckboxListDto checkboxListDto) {
        for(String id : checkboxListDto.getCheckboxList()) {
            springDataJpaRepository.deleteByUserId(id);
        }
        return "ok";
    }

}
