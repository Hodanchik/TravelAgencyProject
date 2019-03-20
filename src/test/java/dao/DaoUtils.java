package dao;


import org.hibernate.annotations.SQLDeleteAll;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface DaoUtils {
    @SqlUpdate("DELETE users")
    int deleteUsers();

    @SqlQuery("SELECT count(*) FROM users")
    int countUsers();

}
