package dao;

import entities.Blog;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> userList = new ArrayList<>();
    private static List<User> followingList = new ArrayList<>();

    public void createUser(User user) {
        userList.add(user);
    }

    public List<User> findAllUsers() {
        return userList;
    }

    public void followUser(User user) {
        followingList.add(user);
    }

    public List<User> followingUsers() {
        return followingList;
    }


}
