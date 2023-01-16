package com.emlakcepte.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emlakcepte.model.Search;
import com.emlakcepte.model.User;
import com.emlakcepte.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void createUser(User user) {
		userRepository.createUser(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAllUsers();
	}

	public void printAllUser() {

		getAllUsers().forEach(user -> System.out.println(user.getName()));

	}

	public void updatePassword(String userName, String newPassword) {
		String username, password;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter username:");// username:user
		username = s.nextLine();
		System.out.print("Enter password:");// password:user
		password = s.nextLine();
		if (username.equals("user") && password.equals("user")) {
			System.out.println("Authentication Successful");
			newPassword = s.nextLine();
		} else {
			System.out.println("Authentication Failed");
		}
	}

	public void saveSearch(Search search, User user) {
		userRepository.saveSearch(search, user);
	}

	public User updateUser(int id, User user) {
		return userRepository.updateUser(id, user);
	}

	public User deleteUser(int id) {
		return userRepository.deleteUser(id);
	}

	public User getUserById(int id) {
		return userRepository.getUserById(id);
	}

	public User getByEmail(String email) {

		//// @formatter:off
		return userRepository.findAllUsers()
				.stream()
				.filter(user -> user.getMail().equals(email))
				.findFirst()
				.get();
		// @formatter:on

	}

}
