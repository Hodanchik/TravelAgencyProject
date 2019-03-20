package dao;

import dao.User;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface UserDaoForTest {
    @SqlUpdate("INSERT INTO users " +
            "( ref, login,  password) "
            +
            "VALUES " +
            "( :ref :login, :password)")
    @GetGeneratedKeys
    int addUser(@BindBean User user);


}

