package lv.javaguru.junit.workshop.section6;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class LoginServiceTest {

    private Database database;
    private LoginServiceImpl loginService;

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String DIFFERENT_PASSWORD = "differentPassword";


    @Before
    public void init() {
        database = mock(Database.class);
        loginService = new LoginServiceImpl(database);
    }

    @Test
    public void shouldBePossibilityToProvideLoginAndPassword() {
        User user = new User(LOGIN, PASSWORD);
        doReturn(Optional.of(user)).when(database).getUserByLogin(LOGIN);
        loginService.login(LOGIN, PASSWORD);
    }

    @Test
    public void whenLoginIsNullThenNotLogin() {
        boolean loginResult = loginService.login(null, PASSWORD);
        assertFalse(loginResult);
    }

    @Test
    public void whenLoginBlankThenNotLogin() {
        boolean loginResult = loginService.login("", PASSWORD);
        assertFalse(loginResult);
    }

    @Test
    public void whenPasswordIsNullThenNotLogin() {
        boolean loginResult = loginService.login(LOGIN, null);
        assertFalse(loginResult);
    }

    @Test
    public void whenPasswordBlankThenNotLogin() {
        boolean loginResult = loginService.login(LOGIN, "");
        assertFalse(loginResult);
    }

    @Test
    public void whenDatabaseNotContainUserThenNotLogin() {
        doReturn(Optional.empty()).when(database).getUserByLogin(LOGIN);
        boolean loginResult = loginService.login(LOGIN, PASSWORD);
        assertFalse(loginResult);
    }

    @Test
    public void whenDatabaseReturnUserWithDifferentPasswordThenNotLogin() {
        User user = new User(LOGIN, DIFFERENT_PASSWORD);
        doReturn(Optional.of(user)).when(database).getUserByLogin(LOGIN);
        boolean loginResult = loginService.login(LOGIN, PASSWORD);
        assertFalse(loginResult);
    }

}
