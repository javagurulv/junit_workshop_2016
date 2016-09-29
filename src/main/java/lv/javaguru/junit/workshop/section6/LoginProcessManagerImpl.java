package lv.javaguru.junit.workshop.section6;


public class LoginProcessManagerImpl implements LoginProcessManager {

    private LoginService loginService;

    public LoginProcessManagerImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void login(String login, String password) {
        try {
            UserAccount userAccount = loginService.login(login, password);
        } catch (Exception e) {
            // manage failed login attempt
        }
    }

}
