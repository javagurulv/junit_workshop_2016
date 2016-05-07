package lv.javaguru.junit.workshop.section6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    @Mock
    private Database database;

    @InjectMocks
    private LoginService loginService = new LoginService();


    @Test
    public void shouldBePossibilityToProvideLoginAndPassword() {
        User user = new User("login", "password");
        doReturn(Optional.of(user)).when(database).getUserByLogin("login");
        loginService.login("login", "password");
    }

    @Test
    public void whenLoginIsNullThenNotLogin() {
        boolean loginResult = loginService.login(null, "password");
        assertFalse(loginResult);
    }

    @Test
    public void whenLoginBlankThenNotLogin() {
        boolean loginResult = loginService.login("", "password");
        assertFalse(loginResult);
    }

    @Test
    public void whenPasswordIsNullThenNotLogin() {
        boolean loginResult = loginService.login("login", null);
        assertFalse(loginResult);
    }

    @Test
    public void whenPasswordBlankThenNotLogin() {
        boolean loginResult = loginService.login("login", "");
        assertFalse(loginResult);
    }

    @Test
    public void whenDatabaseNotContainUserThenNotLogin() {
        doReturn(Optional.empty()).when(database).getUserByLogin("login");
        boolean loginResult = loginService.login("login", "password");
        assertFalse(loginResult);
    }

    @Test
    public void whenDatabaseReturnUserWithDifferentPasswordThenNotLogin() {
        User user = new User("login", "differentPassword");
        doReturn(Optional.of(user)).when(database).getUserByLogin("login");
        boolean loginResult = loginService.login("login", "password");
        assertFalse(loginResult);
    }

}
