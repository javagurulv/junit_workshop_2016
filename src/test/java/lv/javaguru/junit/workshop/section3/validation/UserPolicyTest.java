package lv.javaguru.junit.workshop.section3.validation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class UserPolicyTest {

    @Test
    public void shouldReturnEmptyErrorListWhenNoExceptions() {
        EmptyRule emptyRule = mock(EmptyRule.class);
        PasswordRule passwordRule = mock(PasswordRule.class);

        User user = new User();
        doReturn(new ArrayList<>())
                .when(emptyRule)
                .apply(user);
        doReturn(new ArrayList<>())
                .when(passwordRule)
                .apply(user);

        UserPolicy policy = new UserPolicy(emptyRule, passwordRule);

        List<ValidationError> errors = policy.validate(user);

        assertThat(errors.isEmpty(), is(true));
        verify(emptyRule).apply(user);
        verify(passwordRule).apply(user);
    }



}
