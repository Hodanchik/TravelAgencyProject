package dao.impls;

import dao.UserDao;
import entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;


@Repository
@Component
public class UserDaoImpl implements UserDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(User user) {

        int id = jdbcTemplate.queryForObject("INSERT INTO public.users(login, password) VALUES (?, ?) RETURNING id;",
                new Object[]{user.getLogin(), user.getPassword()}, Integer.class);
        user.setId(id);
    }

    @Override
    public void updateUser(User user) {
        jdbcTemplate.update("UPDATE public.users SET  login=?, password=? WHERE id = ?;",
                user.getLogin(), user.getPassword(), user.getId());
    }


    @Override
    public void deleteUser(User user) {
        jdbcTemplate.update("DELETE FROM public.users WHERE id=?;",
                user.getId());

    }
}
