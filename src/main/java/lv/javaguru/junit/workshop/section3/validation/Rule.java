package lv.javaguru.junit.workshop.section3.validation;

import java.util.List;


public interface Rule {

    void apply(User user, List<ValidationError> errorList);

}
