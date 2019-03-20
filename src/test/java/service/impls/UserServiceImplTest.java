package service.impls;

import dao.UserDao;

import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
@Mock
    UserDao userDao;
User user = new User();
    @Test
    public void addUser() {
        userDao.addUser(user);
        Mockito.verify(userDao).addUser(user);
    }

    @Test
    public void updateUser() {
        userDao.updateUser(user);
        Mockito.verify(userDao).updateUser(user);
    }

    @Test
    public void deleteUser() {
        userDao.deleteUser(user);
        Mockito.verify(userDao).deleteUser(user);
    }
}