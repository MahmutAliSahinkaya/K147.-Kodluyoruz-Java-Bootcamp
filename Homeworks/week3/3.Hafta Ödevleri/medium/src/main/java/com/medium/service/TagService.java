package com.medium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medium.entities.Tag;
import com.medium.repository.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tagRepository;
	
	public void addTag(Tag tag) {
		tagRepository.addTag(tag);
	}
	
	public Tag getTagById(int id) {
		return tagRepository.getTagById(id);
	}
	
	public List<Tag> getAllTags() {
		return tagRepository.getAllTags();
	}
	
	public void updateTag(Tag tag) {
		tagRepository.updateTag(tag);
	}
	
	public void deleteTag(int id) {
		tagRepository.deleteTag(id);
	}

    public Tag findById(int tagId) {
        Tag tag = tagRepository.getTagById(tagId);
        if (tag == null) {
        	System.out.println("Tag not found with id: " + tagId);
            
        }
        return tag;
    }
	
}
