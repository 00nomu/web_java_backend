package web.backend.module.auth.repository;

import lombok.Data;

@Data
public class AuthLoginDto {
    private String id;
    private String password;
}
