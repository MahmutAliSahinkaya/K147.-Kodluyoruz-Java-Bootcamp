package service;

import dao.BlogDao;
import entities.Blog;

import java.util.List;

public class BlogService {

    private BlogDao blogDao = new BlogDao();

    private UserService userService;

    public void createBlog(Blog blog) {
        blogDao.saveBlog(blog);
        System.out.println("createBlog :: " + blog.getTitle());

    }

    public List<Blog> getAll() {
        return blogDao.findAll();
    }

    public void getAllByUsers(String name) {
        getAll().stream()
                .filter(blog -> userService.getAllUser().equals(name))
                .forEach(blog -> System.out.println(blog));
    }

}
