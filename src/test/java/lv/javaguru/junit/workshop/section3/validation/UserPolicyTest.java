package lv.javaguru.junit.workshop.section3.validation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class UserPolicyTest {

    private EmptyRule emptyRule;
    private PasswordRule passwordRule;
    private User user;


    @Before
    public void init() {
        emptyRule = mock(EmptyRule.class);
        passwordRule = mock(PasswordRule.class);
        user = mock(User.class);
    }

    @Test
    public void shouldReturnEmptyErrorListWhenNoExceptions() {
        checkResults(
                new ArrayList<>(),
                new ArrayList<>()
        );
    }

    @Test
    public void shouldReturnErrorsFromEmptyRule() {
        List<ValidationError> emptyRuleErrors = new ArrayList<>();
        emptyRuleErrors.add(ValidationError.CONFIRM_PASSWORD_EMPTY);

        checkResults(emptyRuleErrors, new ArrayList<>());
    }


    private void checkResults(List<ValidationError> emptyRuleErrors,
                              List<ValidationError> passwordRuleErrors) {
        doReturn(emptyRuleErrors)
                .when(emptyRule)
                .apply(user);

        doReturn(passwordRuleErrors)
                .when(passwordRule)
                .apply(user);

        UserPolicy policy = new UserPolicy(emptyRule, passwordRule);

        List<ValidationError> allErrors = policy.validate(user);

        assertThat(allErrors.size(), is(emptyRuleErrors.size() + passwordRuleErrors.size()));
        assertThat(allErrors.containsAll(emptyRuleErrors), is(true));
        assertThat(allErrors.containsAll(passwordRuleErrors), is(true));
    }

}
