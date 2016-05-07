package lv.javaguru.junit.workshop.section3.database;

import java.util.List;


public interface UserDao {

    User getUserByLogin(String login);

    void saveUser(User user);

    List<User> getAllUsers();

}
