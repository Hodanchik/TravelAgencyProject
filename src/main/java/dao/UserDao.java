package dao;

import entity.User;

public interface UserDao {

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);


}
