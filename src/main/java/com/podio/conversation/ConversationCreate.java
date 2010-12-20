package com.podio.conversation;

import java.util.List;

public class ConversationCreate {

	private final String subject;

	private final String text;

	private final List<Integer> participants;

	public ConversationCreate(String subject, String text,
			List<Integer> participants) {
		super();
		this.subject = subject;
		this.text = text;
		this.participants = participants;
	}

	public String getSubject() {
		return subject;
	}

	public String getText() {
		return text;
	}

	public List<Integer> getParticipants() {
		return participants;
	}
}
