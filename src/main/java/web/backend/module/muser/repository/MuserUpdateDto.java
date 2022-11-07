package web.backend.module.muser.repository;

import lombok.Data;
import lombok.Getter;
import web.backend.module.muser.Muser;

@Data
public class MuserUpdateDto {

    private WhereClass where;
    private ContentClass content;

    @Getter
    public class WhereClass {
        public String muserId;
    }

    @Getter
    public class ContentClass extends Muser {
        public String muserId;

        public String muserPassword;

        public int muserMobileSignup;

        public int muserPoint;

        public String muserName;

        public String muserTel;

        public String muserPaymentsType;

        public int muserWorkerLimit;
    }

}
