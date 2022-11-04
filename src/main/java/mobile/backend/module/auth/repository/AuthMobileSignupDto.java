package mobile.backend.module.auth.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthMobileSignupDto {
    private String id;
    private String password;

    @JsonProperty(value = "muser_tel")
    private String muserTel;
}
