package com.medium.repository;



import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.medium.entities.Blog;
import com.medium.entities.Tag;
import com.medium.entities.User;

@Repository
public class UserRepository {
    
    private static List<User> userList = new ArrayList<>();

    public void createUser(User user) {
    	userList.add(user);
    }


    public void deleteUser(User user) {
    	userList.remove(user);
    }


    public List<User> getAllUsers() {
        return userList;
    }
    
    public List<Blog> getBlogsByUser(User user) {
        List<Blog> blogs = user.getBlogs();
        for (Blog blog : blogs) {
            System.out.println(blog.getTitle() + " " + blog.getBlogStatus());
        }
		return blogs;
    }
    
    public void followTag(User user, Tag tag){
        user.getFollowedTags().add(tag);
    }
    public void unfollowTag(User user, Tag tag){
        user.getFollowedTags().remove(tag);
    }
    
    public void followUser(User user1, User user2){
        user1.getFollowedUsers().add(user2);
        user2.getFollowerUsers().add(user1);
    }

    public void unfollowUser(User user1, User user2){
        user1.getFollowedUsers().remove(user2);
        user2.getFollowerUsers().remove(user1);
    }
    
    public void printFollowedUsers(User user) {
        List<User> followedUsers = user.getFollowedUsers();
        for (User followedUser : followedUsers) {
            System.out.println(followedUser.getName());
        }
    }



		public User getUserById(int id) {
		    for (User user : userList) {
		        if (user.getId() == id) {
		            return user;
		        }
		    }
		    return null;
		}
	}







