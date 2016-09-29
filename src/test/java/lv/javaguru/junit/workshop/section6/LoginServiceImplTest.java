package lv.javaguru.junit.workshop.section6;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class LoginServiceImplTest {

    private Database database;
    private LoginService loginService;

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
        loginService = mock(LoginService.class);
        loginService.login(LOGIN, PASSWORD);
        verify(loginService).login(LOGIN, PASSWORD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenLoginIsNull() {
        loginService.login(null, PASSWORD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenLoginIsBlank() {
        loginService.login("", PASSWORD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenPasswordIsNull() {
        loginService.login(LOGIN, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenPasswordIsBlank() {
        loginService.login(LOGIN, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenDatabaseNotContainUser() {
        doReturn(Optional.empty()).when(database).getUserByLogin(LOGIN);
        loginService.login(LOGIN, PASSWORD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenDatabaseContainUserWithDifferentPassword() {
        User user = new User(LOGIN, DIFFERENT_PASSWORD);
        doReturn(Optional.of(user)).when(database).getUserByLogin(LOGIN);
        loginService.login(LOGIN, PASSWORD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenUserAccountNotFound() {
        User user = new User(LOGIN, PASSWORD);
        doReturn(Optional.of(user)).when(database).getUserByLogin(LOGIN);
        doReturn(Optional.empty()).when(database).getUserAccount(user);
        loginService.login(LOGIN, PASSWORD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenUserAccountIsRevoked() {
        User user = new User(LOGIN, PASSWORD);
        doReturn(Optional.of(user)).when(database).getUserByLogin(LOGIN);

        UserAccount userAccount = new UserAccount(user, UserAccountState.REVOKED);
        doReturn(Optional.of(userAccount)).when(database).getUserAccount(user);

        loginService.login(LOGIN, PASSWORD);
    }

    @Test
    public void shouldReturnUserAccount() {
        User user = new User(LOGIN, PASSWORD);
        doReturn(Optional.of(user)).when(database).getUserByLogin(LOGIN);

        UserAccount userAccount = new UserAccount(user, UserAccountState.ACTIVE);
        doReturn(Optional.of(userAccount)).when(database).getUserAccount(user);

        UserAccount realUserAccount = loginService.login(LOGIN, PASSWORD);
        assertThat(realUserAccount, is(sameInstance(userAccount)));
    }

}
