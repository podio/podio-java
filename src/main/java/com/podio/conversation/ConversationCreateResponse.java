package com.podio.conversation;

import org.codehaus.jackson.annotate.JsonProperty;

public class ConversationCreateResponse {

	private int conversationId;

	private int messageId;

	public int getConversationId() {
		return conversationId;
	}

	@JsonProperty("conversation_id")
	public void setConversationId(int conversationId) {
		this.conversationId = conversationId;
	}

	public int getMessageId() {
		return messageId;
	}

	@JsonProperty("message_id")
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
}
