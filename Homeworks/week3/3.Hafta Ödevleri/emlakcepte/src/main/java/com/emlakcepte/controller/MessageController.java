package com.emlakcepte.controller;

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

import com.emlakcepte.model.Message;
import com.emlakcepte.service.MessageService;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {

	@Autowired
	private final MessageService messageService;

	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	@PostMapping
	public Message createMessage(@RequestBody Message message) { // Mesaj ekleyen endpoint
		return messageService.createMessage(message);

	}

	@GetMapping
	public List<Message> getAllMessages() { // Tüm mesajları çağıran endpoint
		return messageService.getAllMessages();
	}

	@GetMapping("/{id}")
	public Message getMessageById(@PathVariable int id) { // ID'ye göre mesajları getiren endpoint
		return messageService.getMessageById(id);
	}

	@PutMapping("/{id}")
	public Message updateMessage(@PathVariable int id, @RequestBody Message message) { // ID'ye göre mesajları
																						// güncelleyen endpoint
		var mes = messageService.updateMessage(id, message);
		return mes;
	}

	@DeleteMapping(path = "{id}")
	public Message deleteMessage(@PathVariable int id) { // ID'ye göre mesajları silen endpoint
		return messageService.deleteMessage(id);
	}

}
