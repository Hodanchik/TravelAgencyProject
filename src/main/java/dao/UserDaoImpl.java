package dao;

import entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;


@Service

public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


//    public void setJdbcTemplate(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }


    @Override
        public void addUser(User user) {

        jdbcTemplate.update("INSERT INTO public.users(login, password) VALUES (?, ?);",
                new Object[]{user.getLogin(), user.getPassword()}, new Object[]{String.class, String.class});

    }

    @Override
    public void updateUser(User user) {
        jdbcTemplate.update("UPDATE public.users SET  login=?, password=? WHERE id = ?;",
                new Object[]{user.getLogin(), user.getPassword(), user.getId()}, new Object[]{String.class, String.class, Integer.class});
    }


    @Override
    public void deleteUser(User user) {
        jdbcTemplate.update("DELETE FROM public.users WHERE id=?;",
                new Object[]{user.getId()}, new Object[]{Integer.class}) ;

    }
}
