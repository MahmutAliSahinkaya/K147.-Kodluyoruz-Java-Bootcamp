package dao;

import entities.Blog;
import java.util.ArrayList;
import java.util.List;

public class BlogDao {
    private static List<Blog> blogList = new ArrayList<>();
    private static List<Blog> tagsFollowingList = new ArrayList<>();
    private static List<Blog> draftList = new ArrayList<>();

    // Kullanıcının blogları eklemesi
    public void saveBlog(Blog blog) {
        blogList.add(blog);
    }
    // Kullanıcının blogları silebilmesi
    public void removeBlog(Blog blog) {
        blogList.remove(blog);
    }
    // kullanıcının blog yayınlaması yayınlanmayan blogların taslak olarak oluşturulabilmesi
    public void publishedBlog(Blog blog) {
        if (blog.getPublished()) {
            blogList.add(blog);
        } else {
            draftList.add(blog);
        }
    }

    // blogları listeleme
    public List<Blog> findAll() {
        return blogList;
    }

    public void followTags(Blog blog) {
        tagsFollowingList.add(blog);
    }

    public List<Blog> followTags() {
        return tagsFollowingList;
    }

}
