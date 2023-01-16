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

import com.medium.entities.Tag;
import com.medium.repository.TagRepository;

@RestController
@RequestMapping("/tags")
public class TagController {
	
	@Autowired
	private TagRepository tagRepository; 
	
	public TagController(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
	@PostMapping
	public void addTag(@RequestBody Tag tag) {
		tagRepository.addTag(tag);
	}
	
	@GetMapping("/{id}")
	public Tag getTagById(@PathVariable int id) {
		return tagRepository.getTagById(id);
	}
	
	@GetMapping
	public List<Tag> getAllTags() {
		return tagRepository.getAllTags();
	}
	
	@PutMapping
	public void updateTag(@RequestBody Tag tag) {
		tagRepository.updateTag(tag);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTag(@PathVariable int id) {
		tagRepository.deleteTag(id);
	}
}