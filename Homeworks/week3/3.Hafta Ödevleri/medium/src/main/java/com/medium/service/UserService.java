package com.medium.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medium.entities.Blog;
import com.medium.entities.Tag;
import com.medium.entities.User;
import com.medium.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void createUser(User user) {
		userRepository.createUser(user);
	}

	public void deleteUser(User user) {
		userRepository.deleteUser(user);
	}
	public User getUserById(int id) {
		return userRepository.getUserById(id);
	}


	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	public User printBlogByUser(User user) {
		List<Blog> blogs = userRepository.getBlogsByUser(user);
		for (Blog blog : blogs) {
			System.out.println(blog.getTitle() + " " + blog.getBlogStatus());
		}
		return user;
	}

	public void followTag(User user, Tag tag) {
		userRepository.followTag(user, tag);
	}

	public void followUser(User user1, User user2) {
		userRepository.followUser(user1, user2);
	}

	public void unfollowUser(User user1, User user2) {
		userRepository.unfollowUser(user1, user2);
	}

	public void printFollowedUsers(User user) {
		List<User> followedUsers = user.getFollowedUsers();
		for (User followedUser : followedUsers) {
			System.out.println(followedUser.getName());
		}
	}
}
