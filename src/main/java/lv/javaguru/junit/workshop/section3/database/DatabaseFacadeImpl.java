package lv.javaguru.junit.workshop.section3.database;

import java.util.List;


public class DatabaseFacadeImpl implements DatabaseFacade {

    private UserDao userDao;

    public DatabaseFacadeImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

}
