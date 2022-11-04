package mobile.backend.module.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "user_info")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userIndex;

    private String userCompanyCode;

    @Column(unique = true)
    private String userId;

    private String userPassword;

    private String userNumber;

    private String userName;

    private String userCreateName;

    private String userGrade;

    @Column(columnDefinition = "DECIMAL")
    private int userAuth;

    private String userPhone;

    @Column(columnDefinition = "DECIMAL")
    private int authMenuCompany;

    @Column(columnDefinition = "DECIMAL")
    private int authMenuUserCustomer;

    @Column(columnDefinition = "DECIMAL")
    private int authMenuUserInfo;

    @Column(columnDefinition = "DECIMAL")
    private int authMenuMuserInfo;

    @Column(columnDefinition = "DECIMAL")
    private int authMenuWarrant;

    @Column(columnDefinition = "LONGTEXT")
    private String userNote;

    private int userDeleteStatus;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime userCreated;

    @LastModifiedDate
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime userUpdated;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        userCreated = now;
        userUpdated = now;
    }

    @PreUpdate
    public void preUpdate() {
        userUpdated = LocalDateTime.now();
    }

    public User(
            String userCompanyCode,
            String userId,
            String userPassword,
            String userNumber,
            String userName,
            String userCreateName,
            String userGrade,
            int userAuth,
            String userPhone,
            int authMenuCompany,
            int authMenuUserCustomer,
            int authMenuUserInfo,
            int authMenuMuserInfo,
            int authMenuWarrant,
            String userNote,
            int userDeleteStatus
    ) {
        this.userCompanyCode = userCompanyCode;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userNumber = userNumber;
        this.userName = userName;
        this.userCreateName = userCreateName;
        this.userGrade = userGrade;
        this.userAuth = userAuth;
        this.userPhone = userPhone;
        this.authMenuCompany = authMenuCompany;
        this.authMenuUserCustomer = authMenuUserCustomer;
        this.authMenuUserInfo = authMenuUserInfo;
        this.authMenuMuserInfo = authMenuMuserInfo;
        this.authMenuWarrant = authMenuWarrant;
        this.userNote = userNote;
        this.userDeleteStatus = userDeleteStatus;
    }

    public void update(User user) {
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

}
