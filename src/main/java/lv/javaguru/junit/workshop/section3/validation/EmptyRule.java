package lv.javaguru.junit.workshop.section3.validation;

import java.util.ArrayList;
import java.util.List;


public class EmptyRule implements Rule {

    public List<ValidationError> apply(User user) {
        List<ValidationError> errorList = new ArrayList<>();

        if(isFieldEmpty(user.getLogin())) {
            errorList.add(ValidationError.LOGIN_FIELD_EMPTY);
        }
        if(isFieldEmpty(user.getPassword())) {
            errorList.add(ValidationError.PASSWORD_FIELD_EMPTY);
        }
        if(isFieldEmpty(user.getConfirmedPassword())) {
            errorList.add(ValidationError.CONFIRM_PASSWORD_EMPTY);
        }

        return errorList;
    }

    private boolean isFieldEmpty(String field) {
        return field == null || "".equals(field);
    }

}
