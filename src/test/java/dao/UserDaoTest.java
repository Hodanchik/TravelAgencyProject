package dao;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class UserDaoTest extends DbSetup{

    private UserDaoForTest userDaoForTest;
    private DaoUtils daoUtils;

    @Before
    public void setUp() throws Exception {
        userDaoForTest = jdbi.onDemand(UserDaoForTest.class);
        daoUtils = jdbi.onDemand(DaoUtils.class);

        daoUtils.deleteUsers();
    }

    @Test
    public void shouldInsertAUser() throws Exception {
        userDaoForTest.addUser(createUser("HUEVINA","TAKOESEBE"));

        assertThat(daoUtils.countUsers(), Is.is(1));
    }

    @Test
    public void shouldInsertTwoUser() throws Exception {
        userDaoForTest.addUser(createUser("Flyway Rocks", "flyway@rocks.com"));
        userDaoForTest.addUser(createUser("JDBI is so Clean", "clean@jdbi.com"));

        assertThat(daoUtils.countUsers(), Is.is(2));
    }

    private User createUser(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        return user;
    }
}

