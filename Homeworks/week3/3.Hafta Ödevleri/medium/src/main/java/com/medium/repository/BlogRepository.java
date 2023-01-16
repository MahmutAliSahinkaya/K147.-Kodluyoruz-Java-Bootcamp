package com.medium.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.medium.entities.Blog;
import com.medium.entities.Tag;
import com.medium.enums.BlogStatus;


@Repository
public class BlogRepository {
	
    private static List<Blog> blogList = new ArrayList<>();
    private TagRepository tagRepository;
    public BlogRepository() {
        
        this.blogList = new ArrayList<>();
    }

    public List<Blog> findAll() {
        return this.blogList;
    }

    public void createBlog(Blog blog) {
        this.blogList.add(blog);
    }

    public Blog findById(int id) {
        for (Blog blog : this.blogList) {
            if (blog.getId() == id) {
                return blog;
            }
        }
        return null;
    }

    public Blog save(Blog blog) {
       
        for (int i = 0; i < this.blogList.size(); i++) {
            if (this.blogList.get(i).getId() == blog.getId()) {
                this.blogList.set(i, blog);
                return blog;
            }
        }
        return null;
    }

    public void addBlogToTag(Blog blog, Tag tag) {
        if (blog.getTag() == null) {
            blog.setTag(tag);
            tag.getBlogs().add(blog);
        }
    }

    public void removeBlogFromTag(Blog blog, Tag tag) {
        blog.setTag(null);
        tag.getBlogs().remove(blog);
    }


    public void setBlogStatus(Blog blog, BlogStatus status) {
        blog.setBlogStatus(status);
    }

    public void removeBlog(Blog blog) {
        this.blogList.remove(blog);
    }


}
