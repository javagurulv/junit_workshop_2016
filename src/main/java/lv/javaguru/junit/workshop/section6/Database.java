package lv.javaguru.junit.workshop.section6;

import java.util.Optional;

public interface Database {

    Optional<User> getUserByLogin(String login);

    Optional<UserAccount> getUserAccount(User user);

}
