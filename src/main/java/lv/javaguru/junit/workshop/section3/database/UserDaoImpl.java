package lv.javaguru.junit.workshop.section3.database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UserDaoImpl implements UserDao {

    private List<User> users = new ArrayList<User>();


    public User getUserByLogin(String login) {
        for(User user : users) {
            if(login.equals(user.getLogin())) {
                return user;
            }
        }
        return null;
    }

    public void saveUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return Collections.unmodifiableList(users);
    }

}
