package dao.impls;

import dao.DbSetup;
import entity.User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
@Component
public class UserDaoImplTest extends DbSetup {


    UserDaoImpl userDao;

   User user = new User("Tester", "Test");
    User temp;


    @Before
    public void setUp() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbSetup.class);
        userDao = ctx.getBean(UserDaoImpl.class);
    }

    @Test
    public void addUser() {
        userDao.addUser(user);
        Assert.assertNotEquals(user.getId(), 0);
        userDao.deleteUser(user);
    }

    @Test
    public void updateUser() {
        userDao.addUser(user);
        User temp = userDao.getUserById(user.getId());
        userDao.updateUser(new User(user.getId(), "NewLogin", "NewPassword"));
        user = userDao.getUserById(user.getId());
        Assert.assertNotEquals(user, temp);

    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void deleteUser() {
        userDao.addUser(user);
        userDao.deleteUser(user);
        userDao.getUserById(user.getId());
    }
}
