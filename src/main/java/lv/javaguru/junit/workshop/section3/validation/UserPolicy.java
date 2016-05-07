package lv.javaguru.junit.workshop.section3.validation;

import java.util.ArrayList;
import java.util.List;


public class UserPolicy {

    private List<Rule> rules = new ArrayList<Rule>();


    public UserPolicy(EmptyRule emptyRule, PasswordRule passwordRule) {
        rules.add(emptyRule);
        rules.add(passwordRule);
    }

    public List<ValidationError> validate(User user) {
        List<ValidationError> errors = new ArrayList<ValidationError>();

        for(Rule rule : rules) {
            rule.apply(user, errors);
        }

        return errors;
    }

}
