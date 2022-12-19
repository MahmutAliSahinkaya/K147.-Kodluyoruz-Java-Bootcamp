package service;

import dao.UserDao;
import entities.User;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public void createUser(User user) {
        System.out.println("userDao objesi: " + userDao.toString());
        userDao.createUser(user);
    }

    public List<User> getAllUser() {
        return userDao.findAllUsers();
    }

    public void printAllUser() {
        getAllUser().forEach(user -> System.out.println(user.getName()));
    }

    public void printAllBlogs() {
        getAllUser().forEach(user -> System.out.println(user.getBlogs()));
    }

}
