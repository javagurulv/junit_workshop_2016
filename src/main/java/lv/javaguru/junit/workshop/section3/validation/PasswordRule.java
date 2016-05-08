package lv.javaguru.junit.workshop.section3.validation;

import java.util.ArrayList;
import java.util.List;


public class PasswordRule implements Rule {

    public List<ValidationError> apply(User user) {
        List<ValidationError> errorList = new ArrayList<>();

        String password = user.getPassword();
        String confirmedPassword = user.getConfirmedPassword();
        if(isFieldNotEmpty(password)
            && isFieldNotEmpty(confirmedPassword)
            && !password.equals(confirmedPassword)) {
            errorList.add(ValidationError.PASSWORD_AND_CONFIRMED_PASSWORD_NOT_EQUAL);
        }

        return errorList;
    }

    private boolean isFieldNotEmpty(String field) {
        return field != null && !"".equals(field);
    }

}
