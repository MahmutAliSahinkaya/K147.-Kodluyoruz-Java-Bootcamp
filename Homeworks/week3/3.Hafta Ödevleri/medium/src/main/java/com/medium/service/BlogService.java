package com.medium.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medium.entities.Blog;
import com.medium.entities.Tag;
import com.medium.enums.BlogStatus;
import com.medium.repository.BlogRepository;
import com.medium.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private UserRepository userRepository;

	public List<Blog> getAllBlogs() {
		return blogRepository.findAll();
	}

	public void createBlog(Blog blog) {
		blogRepository.createBlog(blog);
	}

	public Blog updateBlog(Blog updatedBlog, int id) {
		Blog blog = blogRepository.findById(id);
		if (blog == null) {
			return null;
		}

		blog.setTitle(updatedBlog.getTitle());
		blog.setContent(updatedBlog.getContent());
		blog.setTag(updatedBlog.getTag());
		return blogRepository.save(blog);
	}

	public void printAllBlogs() {
		blogRepository.findAll().forEach(blog -> System.out.println(blog.getTitle() + " " + blog.getBlogStatus()));
	}

	public void addBlogToTag(Blog blog, Tag tag) {
		blogRepository.addBlogToTag(blog, tag);
	}

	public void removeBlogFromTag(Blog blog, Tag tag) {
		blogRepository.removeBlogFromTag(blog, tag);
	}

	public void draftBlog(Blog blog) {
		blogRepository.setBlogStatus(blog, BlogStatus.DRAFT);
	}

	public void publishBlog(Blog blog) {
		blogRepository.setBlogStatus(blog, BlogStatus.PUBLISHED);
	}

	public void removeBlog(Blog blog) {
		blogRepository.removeBlog(blog);
	}

    public Blog findById(int blogId) {
        for (Blog blog : this.getAllBlogs()) {
            if (blog.getId() == blogId) {
                return blog;
            }
        }
        return null;
    }


}
