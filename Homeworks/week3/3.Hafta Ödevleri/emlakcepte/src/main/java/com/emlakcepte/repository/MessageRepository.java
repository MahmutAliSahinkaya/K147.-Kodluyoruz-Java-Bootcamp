package com.emlakcepte.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.emlakcepte.model.Message;

@Repository
public class MessageRepository {

	private static List<Message> messageList = new ArrayList<>();

	public Message save(Message messageRequest) {
		messageList.add(messageRequest);
		return messageRequest;
	}

	public List<Message> findAll() {
		return messageList;
	}

	public Message update(int id, Message messageRequest) {

		int indexOf = messageList
				.indexOf(messageList.stream().filter(message -> message.getId() == id).findFirst().orElseThrow());

		messageRequest.setId(id);
		messageList.set(indexOf, messageRequest);

		return messageRequest;

	}

	public Message remove(int id) {
		Message message1 = messageList.stream().filter(message -> message.getId() == id).findFirst().orElseThrow();
		messageList.remove(message1);
		return message1;
	}

	public Message findById(int id) {

		return messageList.stream().filter(message -> message.getId() == id).findFirst().orElseThrow();
	}

}
