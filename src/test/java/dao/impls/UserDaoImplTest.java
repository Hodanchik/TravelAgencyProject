package dao.impls;

import dao.DaoUtils;
import dao.DbSetup;
import dao.UserDao;
import entity.User;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import static org.junit.Assert.*;
@Repository
@Component
public class UserDaoImplTest extends DbSetup {

//@Autowired
  UserDaoImpl userDao  ;

    DaoUtils daoUtils;
    User user;
    User temp;



    @Before
    public void setUp() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbSetup.class);
        userDao = ctx.getBean(UserDaoImpl.class);
//        userDao = jdbi.onDemand(UserDaoImpl.class);
//        daoUtils = jdbi.onDemand(DaoUtils.class);
//        daoUtils.deleteUsers();
    }
    @Test
    public void addUser() {
        user = new User();
        user.setLogin("dfgc");
        user.setPassword("drtgh");
        userDao.addUser(user);
        temp = new User(user.getId());

        Assert.assertEquals("dfgc", temp.getLogin());
        userDao.deleteUser(user);
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUser() {
    }
}