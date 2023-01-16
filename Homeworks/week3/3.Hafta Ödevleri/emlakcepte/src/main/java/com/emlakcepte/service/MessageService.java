package com.emlakcepte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emlakcepte.model.Message;
import com.emlakcepte.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private final MessageRepository messageRepository;

	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public Message createMessage(Message messageRequest) {
		return messageRepository.save(messageRequest);
	}

	public List<Message> getAllMessages() {
		return messageRepository.findAll();
	}

	public Message updateMessage(int id, Message messageRequest) {
		return messageRepository.update(id, messageRequest);
	}

	public Message deleteMessage(int id) {
		return messageRepository.remove(id);
	}

	public Message getMessageById(int id) {
		return messageRepository.findById(id);
	}

}
