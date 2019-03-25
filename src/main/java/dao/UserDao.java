package dao;

import entity.User;
import org.springframework.stereotype.Repository;

@Repository

public interface UserDao {

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    User getUserById(int id);
}
