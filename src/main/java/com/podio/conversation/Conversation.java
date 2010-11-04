package com.podio.conversation;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.user.UserMini;

public class Conversation {

	/**
	 * The id of the conversation
	 */
	private int id;

	/**
	 * The subject of the conversation
	 */
	private String subject;

	/**
	 * The messages in the conversation
	 */
	private List<Message> messages;

	/**
	 * The list of participants in the conversation
	 */
	private List<UserMini> participants;

	@JsonProperty("conversation_id")
	public int getId() {
		return id;
	}

	@JsonProperty("conversation_id")
	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<UserMini> getParticipants() {
		return participants;
	}

	public void setParticipants(List<UserMini> participants) {
		this.participants = participants;
	}
}
