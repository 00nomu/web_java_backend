package web.backend.module.user.repository;

import lombok.Data;
import web.backend.module.company.Company;
import web.backend.module.user.User;

@Data
public class UserListDto {
    public UserListDto( User user, Company company ) {
        if(company != null) {
            this.companyName = company.getCompanyName();
        }
        this.userCompanyCode = user.getUserCompanyCode();
        this.userId = user.getUserId();
        this.userPassword = user.getUserPassword();
        this.userNumber = user.getUserNumber();
        this.userName = user.getUserName();
        this.userCreateName = user.getUserCreateName();
        this.userGrade = user.getUserGrade();
        this.userAuth = user.getUserAuth();
        this.userPhone = user.getUserPhone();
        this.authMenuCompany = user.getAuthMenuCompany();
        this.authMenuUserCustomer = user.getAuthMenuUserCustomer();
        this.authMenuUserInfo = user.getAuthMenuUserInfo();
        this.authMenuMuserInfo = user.getAuthMenuMuserInfo();
        this.authMenuWarrant = user.getAuthMenuWarrant();
        this.userNote = user.getUserNote();
        this.userDeleteStatus = user.getUserDeleteStatus();
    }

    private String companyName;

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
