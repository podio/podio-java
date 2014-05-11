package com.podio.conversation;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.contact.ProfileMini;

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
	 * The list of participants in the conversation
	 */
	private List<ProfileMini> participants;

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

	public List<ProfileMini> getParticipants() {
		return participants;
	}

	public void setParticipants(List<ProfileMini> participants) {
		this.participants = participants;
	}
}
