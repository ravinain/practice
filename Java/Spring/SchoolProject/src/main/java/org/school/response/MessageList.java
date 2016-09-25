package org.school.response;

import java.util.ArrayList;
import java.util.List;

public class MessageList {

	private List<Message> messages = new ArrayList<Message>();

	public List<Message> getMessages() {
		return messages;
	}

	public void addMessage(Message message) {
		this.messages.add(message);
	}
	
}
