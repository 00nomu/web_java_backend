package mobile.backend.module.user.repository;

import lombok.Data;

@Data
public class UserCreateDto {
    private String userCompanyCode;
    private String userId;
    private String userPassword;
    private String userNumber;
    private String userName;
    private String userCreateName;
    private String userGrade;
    private int userAuth;
    private String userPhone;
    private int authMenuCompany;
    private int authMenuUserCustomer;
    private int authMenuUserInfo;
    private int authMenuMuserInfo;
    private int authMenuWarrant;
    private String userNote;
    private int userDeleteStatus;
}
