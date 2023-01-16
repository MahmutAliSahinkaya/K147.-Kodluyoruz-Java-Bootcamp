package com.medium.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.medium.entities.Blog;
import com.medium.entities.Tag;
import com.medium.repository.BlogRepository;
import com.medium.service.BlogService;
import com.medium.service.TagService;
import com.medium.service.UserService;

@RestController
@RequestMapping("/blogs")
public class BlogController {
	
	@Autowired
    private BlogRepository blogRepository;

	@Autowired
	private TagService tagService;
	
	@Autowired
	private UserService userService;

    @Autowired
    private BlogService blogService;

    
    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @PostMapping
    public void createBlog(@RequestBody Blog blog) {
        blogService.createBlog(blog);
    }

    @PutMapping("/{id}")
    public Blog updateBlog(@RequestBody Blog updatedBlog, @PathVariable int id) {
        return blogService.updateBlog(updatedBlog, id);
    }

    @GetMapping("/print")
    public void printAllBlogs() {
        blogService.printAllBlogs();
    }

    @PutMapping("/{blogId}/tags/{tagId}")
    public void addBlogToTag(@PathVariable int blogId, @PathVariable int tagId) {
        Blog blog = blogService.findById(blogId);
        Tag tag = tagService.findById(tagId);
        blogService.addBlogToTag(blog, tag);
    }

    @DeleteMapping("/{blogId}/tags/{tagId}")
    public void removeBlogFromTag(@PathVariable int blogId, @PathVariable int tagId) {
        Blog blog = blogService.findById(blogId);
        Tag tag = tagService.findById(tagId);
        blogService.removeBlogFromTag(blog, tag);
    }

    @PutMapping("/{id}/draft")
    public void draftBlog(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        blogService.draftBlog(blog);
    }

    @PutMapping("/{id}/publish")
    public void publishBlog(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        blogService.publishBlog(blog);
    }

    @DeleteMapping("/{id}")
    public void removeBlog(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        blogService.removeBlog(blog);
    }


    }
