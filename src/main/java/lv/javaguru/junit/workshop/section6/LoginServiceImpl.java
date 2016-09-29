package lv.javaguru.junit.workshop.section6;

import java.util.Optional;

class LoginServiceImpl implements LoginService {

    private Database database;


    LoginServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public UserAccount login(String login, String password) {
        makeSureLoginNotEmpty(login);
        makeSurePasswordNotEmpty(password);

        User user = findUserInDB(login);
        makeSurePasswordsAreEqual(password, user);

        UserAccount userAccount = findUserAccountInDB(user);
        makeSureUserAccountNotRevoked(userAccount);

        return userAccount;
    }

    private User findUserInDB(String login) {
        Optional<User> userOptional = database.getUserByLogin(login);
        return userOptional.orElseThrow(
                () -> new IllegalArgumentException("User not found in DB!")
        );
    }

    private UserAccount findUserAccountInDB(User user) {
        Optional<UserAccount> userAccountOptional = database.getUserAccount(user);
        return userAccountOptional.orElseThrow(
                () -> new IllegalArgumentException("User Account not found in DB!")
        );
    }

    private void makeSureUserAccountNotRevoked(UserAccount userAccount) {
        if (userAccount.isRevoked()) {
            throw new IllegalArgumentException("User Account is revoked!");
        }
    }

    private void makeSurePasswordsAreEqual(String password, User user) {
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException();
        }
    }

    private void makeSurePasswordNotEmpty(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password is empty!");
        }
    }

    private void makeSureLoginNotEmpty(String login) {
        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("Login is empty!");
        }
    }

}
