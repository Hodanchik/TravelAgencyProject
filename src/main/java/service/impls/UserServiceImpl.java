package service.impls;

import dao.UserDao;

import dao.impls.UserDaoImpl;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import service.UserService;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

}
