import entities.Blog;
import entities.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("Mahmut");
        user1.setEmail("mahmutsahinkaya@gmail.com");
        user1.setBio("daha sonra bio eklenecek");
        user1.setPassword("123456");
        user1.setProfilePhoto("sonradan ekleyeceğiz");


        User user2 = new User("ali", "mahmutalisahinkaya@gmail.com", "123123", "foto yok", "bio da yok");

        userList.add(user1);
        userList.add(user2);

        String[] tags = new String[5];
        tags[0] = "git";
        tags[1] = "git commands";
        tags[2] = "git branch";
        tags[3] = "java";
        tags[4] = "java8";

        Blog mahmutBlog = new Blog("Daily Git Commands",
                "https://miro.medium.com/max/1400/0*p4eGQrb2mfROeQHh",
                "Today, i will try to tell what i use git commands just in my daily life \uD83D\uDE05\n" +
                        "\n" +
                        "git add . or git add fileName ➡️ add a file to your commit\n" +
                        "git commit -m “commit message” ➡️ commit to your local repo\n" +
                        "git push origin branch-name ➡️ pushs all commits in your local branch to remote(origin means remote repo but you can change it)\n" +
                        "git checkout branch-name ➡️ switch to existing branch\n" +
                        "git checkout -b branch-name ➡️ creates and switch new branch",
                LocalDateTime.now(),
                tags);

        mahmutBlog.setPublished(true);

        Blog mahmutBlog2 = new Blog();

        mahmutBlog2.setPublished(false);
        mahmutBlog2.setTitle("ikinci blog yazım");
        mahmutBlog2.setPublishDate(LocalDateTime.now());
        mahmutBlog.setTags();

        List<Blog> mahmutBlogs = new ArrayList<>();
        mahmutBlogs.add(mahmutBlog);
        mahmutBlogs.add(mahmutBlog2);

        user2.setBlogs(mahmutBlogs);

        Blog mahmutBlog3 = new Blog();
        mahmutBlog.setTitle("Shell Script in Real Life");
        mahmutBlog.setPublished(true);
        user1.setBlogs(Arrays.asList(mahmutBlog));

        //kişilerin blogları başlıkları ile listelenecek
        // blog publish edildiyse normal olarak yayınlanacak eğer publish edilmediyse taslak oluşturulacak
        for (User user : userList) {
            for (Blog blog : user.getBlogs()) {
                if (blog.getPublished()) {
                    System.out.println("User:" + user.getName() + "Blog: " + blog.getTitle());
                } else {
                    blog.setDraft(blog.getTitle());
                    System.out.println("User: " + user.getName() + " created an draft titled: " + blog.getTitle());
                }
            }
        }
        System.out.println("--Your stories--");

        findPublichedBlogByUserName("Mahmut");

        List<User> following = new ArrayList<>();
        user1.setFollowing(user2);
        System.out.println(user1.getFollowing().);
    }



    // Kullanıcının publish edilmiş bloglarını kullanıcı ismi ile gösterme
    private static void findPublichedBlogByUserName(String name) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(name)) {
                System.out.println(userList.get(i).getName());

                for (int j = 0; j < userList.get(i).getBlogs().size(); j++) {
                    if (userList.get(i).getBlogs().get(j).getPublished()) {
                        System.out.println(userList.get(i).getBlogs().get(j).getTitle());
                    }
                }
            }
        }
    }
}