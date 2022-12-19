package entities;

import java.time.LocalDateTime;
import java.util.List;

public class Blog {
    private String title;
    private String photoUrl;
    private String content;
    private LocalDateTime publishDate;
    private String[] tags;
    private String draft;
    private Boolean isPublished = false;
    private List<User> tagsFollowing;

    public Blog() {
    }

    public Blog(String title, String photoUrl, String content, LocalDateTime publishDate, String[] tags) {
        this.title = title;
        this.photoUrl = photoUrl;
        this.content = content;
        this.publishDate = publishDate;
        this.tags = tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getDraft() {
        return draft;
    }

    public void setDraft(String draft) {
        this.draft = draft;
    }

    public List<User> getTagsFollowing() {
        return tagsFollowing;
    }

    public void setTagsFollowing(List<User> tagsFollowing) {
        this.tagsFollowing = tagsFollowing;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags() {
        this.tags = tags;
    }

    public Boolean getPublished() {
        return isPublished;
    }

    public void setPublished(Boolean published) {
        isPublished = published;
    }
}