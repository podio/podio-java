package com.podio.conversation;

import org.codehaus.jackson.annotate.JsonProperty;

public class MessageCreateResponse {

	private int messageId;

	public int getMessageId() {
		return messageId;
	}

	@JsonProperty("message_id")
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
}
