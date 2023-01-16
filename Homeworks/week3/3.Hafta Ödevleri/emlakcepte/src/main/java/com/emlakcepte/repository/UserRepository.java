package com.emlakcepte.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.emlakcepte.model.Search;
import com.emlakcepte.model.User;

@Repository
public class UserRepository {

	private static List<User> userList = new ArrayList<>();

	public void createUser(User user) {
		userList.add(user);
	}

	public List<User> getAllUsers() {
		return userList;
	}

	public List<User> findAllUsers() {
		return userList;
	}

	public void printAllUser() {
		for (User user : userList) {
			System.out.println(user.getName());
		}
	}

	public void updatePassword(String userName, String newPassword) {
		String username, password;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter username:");
		username = s.nextLine();
		System.out.print("Enter password:");
		password = s.nextLine();
		if (username.equals("user") && password.equals("user")) {
			System.out.println("Authentication Successful");
			newPassword = s.nextLine();
		} else {
			System.out.println("Authentication Failed");
		}
	}

	public void saveSearch(Search search, User user) {
		for (User u : userList) {
			if (u.equals(user)) {
				u.getSearches().add(search);
			}
		}
	}

	public User updateUser(int id, User user) {
		for (User u : userList) {
			if (u.getId() == id) {
				u.setName(user.getName());
				u.setMail(user.getMail());
				u.setPassword(user.getPassword());
				return u;
			}
		}
		return null;
	}

	public User deleteUser(int id) {
		for (User u : userList) {
			if (u.getId() == id) {
				userList.remove(u);
				return u;
			}
		}
		return null;
	}

	public User getUserById(int id) {
		for (User u : userList) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	public User getByEmail(String email) {
		for (User user : userList) {
			if (user.getMail().equals(email)) {
				return user;
			}
		}
		return null;
	}

}
