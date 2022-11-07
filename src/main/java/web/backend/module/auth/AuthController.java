package web.backend.module.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.backend.module.auth.repository.AuthLoginDto;
import web.backend.module.auth.repository.AuthMobileSignupDto;
import web.backend.module.muser.Muser;
import web.backend.response.CommonResponse;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    @PostMapping("/mobile/login")
    public CommonResponse<Muser> mobileLogin(HttpServletResponse response, @RequestBody AuthLoginDto authLoginDto) {
        return new CommonResponse<Muser>(true,service.mobileLogin(response,authLoginDto));
    }

    @PostMapping("/mobile/signup")
    public CommonResponse<String> mobileSignUp(@RequestBody AuthMobileSignupDto authMobileSignupDto) {
            return new CommonResponse<String>(false,service.mobileSignUp(authMobileSignupDto));
    }

    @GetMapping("/mobile/logout")
    public CommonResponse<String> mobileLogout(HttpServletResponse response ) {
        return new CommonResponse<String>(true, service.mobileLogout(response));
    }

    @PostMapping("/web/login")
    public CommonResponse<String> webLogin(HttpServletResponse response, @RequestBody AuthLoginDto authLoginDto) {
        return new CommonResponse<>(true, service.webLogin(response, authLoginDto));
    }

    @GetMapping("/web/logout")
    public CommonResponse<String> webLogout(HttpServletResponse response ) {
        return new CommonResponse<String>(true, service.webLogout(response));
    }

}
