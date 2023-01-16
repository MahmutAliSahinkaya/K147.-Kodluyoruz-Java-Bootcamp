package com.medium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medium.entities.Tag;
import com.medium.entities.User;
import com.medium.service.TagService;
import com.medium.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
    private UserService userService;
	@Autowired
    private TagService tagService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }



    @DeleteMapping("/{id}")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }


    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{id}/blogs")
    public void printBlogByUser(@RequestBody User user) {
        User user1 = userService.printBlogByUser(user);
        userService.printBlogByUser(user1);
    }
    
    @PutMapping("/{id}/follow-tag/{tagName}")
    public void followTag(@PathVariable int id, @PathVariable int tagId) {
        User user = userService.getUserById(id);
        Tag tag = tagService.getTagById(tagId);
        userService.followTag(user, tag);
    }
    
    @PutMapping("/{id1}/follow/{id2}")
    public void followUser(@PathVariable int id1, @PathVariable int id2) {
        User user1 = userService.getUserById(id1);
        User user2 = userService.getUserById(id2);
        userService.followUser(user1, user2);
    }

    @DeleteMapping("/{id1}/unfollow/{id2}")
    public void unfollowUser(@PathVariable int id1, @PathVariable int id2) {
        User user1 = userService.getUserById(id1);
        User user2 = userService.getUserById(id2);
        userService.unfollowUser(user1, user2);
    }
    
    @GetMapping("/{id}/followed-users")
    public void printFollowedUsers(@PathVariable int id) {
        User user = userService.getUserById(id);
        userService.printFollowedUsers(user);
    }
    
    
}
