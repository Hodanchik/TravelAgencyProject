package dao.impls;

import dao.UserDao;
import entity.User;

import net.bytebuddy.dynamic.scaffold.TypeInitializer;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


@Repository
@Component

public class UserDaoImpl implements UserDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addUser(User user) {
        Object[] arg = new Object[]{user.getLogin(), user.getPassword()};
        int id = jdbcTemplate.queryForObject("INSERT INTO users(id, login, password) VALUES (DEFAULT, ?, ?)",
                arg, Integer.class);
        user.setId(id);
    }

    @Override
    public User getUserById(int id) {
        String sql = "Select * FROM users where ID=?";
        User user = jdbcTemplate.queryForObject(sql,
                new Object[]{id}, new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user2 = new User();
                        user2.setId(rs.getInt("id"));
                        user2.setLogin(rs.getString("login"));
                        user2.setPassword(rs.getString("password"));
                        return user2;
                    }

                });

        return user;

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
