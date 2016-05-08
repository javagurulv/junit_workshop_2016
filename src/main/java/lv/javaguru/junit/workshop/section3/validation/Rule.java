package lv.javaguru.junit.workshop.section3.validation;

import java.util.List;

public interface Rule {

    List<ValidationError> apply(User user);

}
