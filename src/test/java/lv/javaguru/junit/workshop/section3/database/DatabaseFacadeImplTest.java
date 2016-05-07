package lv.javaguru.junit.workshop.section3.database;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class DatabaseFacadeImplTest {


    @Test
    public void shouldInvokeSaveUserMethod() {
        UserDao userDao = mock(UserDao.class);

        DatabaseFacade databaseFacade = new DatabaseFacadeImpl(userDao);

        User user = new User();

        databaseFacade.saveUser(user);

        verify(userDao, times(1)).saveUser(user);
    }

}