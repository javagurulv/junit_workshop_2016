package lv.javaguru.junit.workshop.section6;

import java.util.Optional;

public class LoginService {

    private Database database;


    public boolean login(String login, String password) {

        if (isLoginNotProvided(login)) {
            return false;
        }

        if (isPasswordNotProvided(password)) {
            return false;
        }

        Optional<User> userOptional = database.getUserByLogin(login);
        if (!userOptional.isPresent()) {
            return false;
        } else {
            User userFromDb = userOptional.get();
            String userFromDbPassword = userFromDb.getPassword();
            if (!password.equals(userFromDbPassword)) {
                return false;
            }
        }

        return true;
    }

    private boolean isLoginNotProvided(String login) {
        return login == null || login.equals("");
    }

    private boolean isPasswordNotProvided(String password) {
        return password == null || password.equals("");
    }

}
