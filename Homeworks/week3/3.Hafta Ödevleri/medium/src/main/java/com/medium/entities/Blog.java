package com.medium.entities;

import java.util.List;

import com.medium.enums.BlogStatus;

public class Blog {
	private int id;
    private String title;
    private String content;
    private User user;
    private Tag tag;
    private BlogStatus blogStatus;

    public Blog() {
    }

    public Blog(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.tag = new Tag();
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public BlogStatus getBlogStatus() {
		return blogStatus;
	}

	public void setBlogStatus(BlogStatus blogStatus) {
		this.blogStatus = blogStatus;
	}
  
}