package entities;

import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    private String profilePhoto;
    private String bio;
    private List<Blog> blogs;
    private List<User> following;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String email, String password, String profilePhoto, String bio) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.profilePhoto = profilePhoto;
        this.bio = bio;
        this.blogs = blogs;
        this.following = following;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public List<User> getFollowing() {

        return following;
    }

    public void setFollowing(User user) {
        user.getName();
    }
}