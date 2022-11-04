package mobile.backend.module.muser.repository;

import lombok.Data;

import javax.persistence.Column;

@Data
public class MuserCreateDto {

    private String muserId;

    private String muserPassword;

    private int muserMobileSignup;

    private int muserPoint;

    private String muserName;

    private String muserTel;

    private String muserPaymentsType;

    private int muserWorkerLimit;
}
