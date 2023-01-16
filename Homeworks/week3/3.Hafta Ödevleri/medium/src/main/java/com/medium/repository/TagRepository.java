package com.medium.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.medium.entities.Tag;

@Repository
public class TagRepository {
	
	private static List<Tag> tags = new ArrayList<>();
	
	public TagRepository() {
		tags = new ArrayList<>(); 
	}
	
	public void addTag(Tag tag) {
		tags.add(tag); 
	}
	
	public Tag getTagById(int id) {
		for (Tag tag : tags) { 
			if (tag.getId() == id) {
				return tag;
			}
		}
		return null; 
	}
	
	public List<Tag> getAllTags() {
		return tags; 
	}
	
	public void updateTag(Tag tag) {
		for (int i = 0; i < tags.size(); i++) {
			if (tags.get(i).getId() == tag.getId()) {
				tags.set(i, tag); 
				break;
			}
		}
	}
	
	public void deleteTag(int id) {
		for (int i = 0; i < tags.size(); i++) {
			if (tags.get(i).getId() == id) {
				tags.remove(i); 
				break;
			}
		}
	}

}
