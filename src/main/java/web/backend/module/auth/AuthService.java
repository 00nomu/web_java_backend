package web.backend.module.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.backend.auth.JwtTokenManager;
import web.backend.exception.CustomRuntimeException;
import web.backend.module.auth.repository.AuthLoginDto;
import web.backend.module.auth.repository.AuthMobileSignupDto;
import web.backend.module.muser.Muser;
import web.backend.module.muser.repository.MuserSpringDataJpaRepository;
import web.backend.module.user.User;
import web.backend.module.user.repository.UserSpringDataJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AuthService {

    private final MuserSpringDataJpaRepository muserSpringDataJpaRepository;
    private final UserSpringDataJpaRepository userSpringDataJpaRepository;


    JwtTokenManager jwtTokenManager = new JwtTokenManager();

    public Muser mobileLogin(HttpServletResponse response, AuthLoginDto authLoginDto) {
        Optional<Muser> userOne = muserSpringDataJpaRepository.findByMuserIdAndMuserPassword(
                authLoginDto.getId(),
                authLoginDto.getPassword()
        );

        if(userOne.isEmpty()) {
            throw new CustomRuntimeException("none");
        }

        Muser user = userOne.get();

        Map<String, Object> tokenMap = new HashMap<>();

        tokenMap.put("userIndex", user.getMuserIndex());
        tokenMap.put("userId", user.getMuserId());
        tokenMap.put("userPassword", user.getMuserPassword());
        tokenMap.put("userName", user.getMuserName());
        tokenMap.put("userPoint", user.getMuserPoint());
        tokenMap.put("userTel", user.getMuserTel());
        tokenMap.put("userPaymentsType", user.getMuserPaymentsType());
        tokenMap.put("userWorkerLimit", user.getMuserWorkerLimit());

        String tokenString = jwtTokenManager.generateToken("loginInwebapp", tokenMap);

        Cookie cookie = new Cookie("loginInwebapp", tokenString);
        cookie.setPath("/");
        cookie.setMaxAge(86400000); // 하루

        response.addCookie(cookie);

        return user;
    }

    public String mobileSignUp(AuthMobileSignupDto authMobileSignupDto) {
        Optional<Muser> userOne = muserSpringDataJpaRepository.findByMuserId(authMobileSignupDto.getId());

        if (userOne.isEmpty()) {
            Muser saveMuser = new Muser(
                    authMobileSignupDto.getId(),
                    authMobileSignupDto.getPassword(),
                    1,
                    0,
                    "",
                    authMobileSignupDto.getMuserTel(),
                    "포인트",
                    2
            );
            muserSpringDataJpaRepository.save(saveMuser);

            return "";
        } else {
            throw new CustomRuntimeException("duple");
        }
    }

    public String mobileLogout(HttpServletResponse response) {
        Cookie cookie = new Cookie("loginInwebapp", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return "ok";
    }

    public String webLogin(HttpServletResponse response, AuthLoginDto authLoginDto) {
        Optional<User> userOne = userSpringDataJpaRepository.findByUserIdAndUserPassword(
                authLoginDto.getId(),
                authLoginDto.getPassword()
        );

        if(userOne.isEmpty()) {
            throw new CustomRuntimeException("none");
        }

        User user = userOne.get();

        Map<String, Object> tokenMap = new HashMap<>();

        tokenMap.put("user_id", user.getUserId());
        tokenMap.put("user_password", user.getUserPassword());
        tokenMap.put("user_phone", user.getUserPhone());
        tokenMap.put("user_name", user.getUserName());
        tokenMap.put("user_grade", user.getUserGrade());
        tokenMap.put("user_number", user.getUserNumber());
        tokenMap.put("user_auth", user.getUserAuth());
        tokenMap.put("auth_menu_company", user.getAuthMenuCompany());
        tokenMap.put("auth_menu_user_customer", user.getAuthMenuUserCustomer());
        tokenMap.put("auth_menu_user_info", user.getAuthMenuUserInfo());
        tokenMap.put("auth_menu_muser_info", user.getAuthMenuMuserInfo());
        tokenMap.put("auth_menu_warrant", user.getAuthMenuWarrant());
        tokenMap.put("company_code", user.getUserCompanyCode());

        String tokenString = jwtTokenManager.generateToken("isLogined", tokenMap);

        Cookie cookie = new Cookie("isLogined", tokenString);
        cookie.setPath("/");
        cookie.setMaxAge(86400000); // 하루

        response.addCookie(cookie);

        return "ok";
    }

    public String webLogout(HttpServletResponse response) {
        Cookie cookie = new Cookie("isLogined", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "ok";
    }


}
