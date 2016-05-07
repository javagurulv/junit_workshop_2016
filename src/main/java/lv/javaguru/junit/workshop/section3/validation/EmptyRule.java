package lv.javaguru.junit.workshop.section3.validation;

import java.util.List;


public class EmptyRule implements Rule {

    public void apply(User user, List<ValidationError> errorList) {
        if(isFieldEmpty(user.getLogin())) {
            errorList.add(ValidationError.LOGIN_FIELD_EMPTY);
        }
        if(isFieldEmpty(user.getPassword())) {
            errorList.add(ValidationError.PASSWORD_FIELD_EMPTY);
        }
        if(isFieldEmpty(user.getConfirmedPassword())) {
            errorList.add(ValidationError.CONFIRM_PASSWORD_EMPTY);
        }
    }

    private boolean isFieldEmpty(String field) {
        return field == null || "".equals(field);
    }

}
