package com.emlakcepte.converter;

import com.emlakcepte.model.User;
import com.emlakcepte.request.UserRequest;
import com.emlakcepte.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {


    public UserResponse convert(User user) {
        UserResponse response = new UserResponse();
        response.setEmail(user.getEmail());
        response.setId(user.getId());
        response.setName(user.getName());
        response.setUserType(user.getUserType());
        return response;
    }

    public User convert(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setUserType(userRequest.getUserType());
        return user;
    }

    public List<UserResponse> convert(List<User> userList) {
        List<UserResponse> userResponses = new ArrayList<>();

        for (User user : userList) {
            userResponses.add(convert(user));
        }
        return userList.stream().map(this::convert).toList();

    }


}
