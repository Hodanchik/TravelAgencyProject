package dao.impls;

import dao.UserDao;
import entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Optional;


@Repository
@Component

public class UserDaoImpl implements UserDao {



    private JdbcTemplate jdbcTemplate;

    @Autowired
    public  void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void addUser(User user) {

        int id = jdbcTemplate.queryForObject("INSERT INTO public.users(login, password) VALUES (?, ?) RETURNING id;",
                new Object[]{user.getLogin(), user.getPassword()}, Integer.class);
        user.setId(id);
    }
    
    public Optional<User> get(Integer id){


        return Optional.of(jdbcTemplate.queryForObject("SELECT id, login, password FROM public.\"users\" WHERE id=?",
                new Object[]{id}, User.class));
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
