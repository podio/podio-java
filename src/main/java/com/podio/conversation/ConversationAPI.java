package com.podio.conversation;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;
import com.podio.common.Reference;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class ConversationAPI extends BaseAPI {

	public ConversationAPI(ResourceFactory resourceFactory) {
		super(resourceFactory);
	}

	/**
	 * Creates a new conversation with a list of users. Once a conversation is
	 * started, the participants cannot (yet) be changed.
	 * 
	 * @param subject
	 *            The subject of the conversation
	 * @param text
	 *            The text of the first message in the conversation
	 * @param participants
	 *            List of participants in the conversation (not including the
	 *            sender)
	 * @return The id of the newly created conversation
	 */
	public int createConversation(String subject, String text,
			List<Integer> participants) {
		return createConversation(subject, text, participants, null);
	}

	/**
	 * Creates a new conversation with a list of users. Once a conversation is
	 * started, the participants cannot (yet) be changed.
	 * 
	 * @param subject
	 *            The subject of the conversation
	 * @param text
	 *            The text of the first message in the conversation
	 * @param participants
	 *            List of participants in the conversation (not including the
	 *            sender)
	 * @param reference
	 *            The object the conversation should be created on, if any
	 * @return The id of the newly created conversation
	 */
	public int createConversation(String subject, String text,
			List<Integer> participants, Reference reference) {
		WebResource resource;
		if (reference != null) {
			resource = getResourceFactory().getApiResource(
					"/conversation/" + reference.toURLFragment());
		} else {
			resource = getResourceFactory().getApiResource("/conversation/");
		}

		return resource
				.entity(new ConversationCreate(subject, text, participants),
						MediaType.APPLICATION_JSON_TYPE)
				.post(ConversationCreateResponse.class).getConversationId();
	}

	/**
	 * Gets the conversation including participants and messages with the the
	 * given id. Only participants in the conversation is allowed to view the
	 * conversation.
	 * 
	 * @param conversationId
	 *            The id of the conversation to get
	 * @return The conversation requested
	 */
	public Conversation getConversation(int conversationId) {
		return getResourceFactory().getApiResource(
				"/conversation/" + conversationId).get(Conversation.class);
	}

	/**
	 * Returns a list of all the conversations on the object that the active
	 * user is part of.
	 * 
	 * @param object
	 *            The object to get conversations on
	 * @return The list of conversations
	 */
	public List<Conversation> getConversationsOnObject(Reference object) {
		return getResourceFactory().getApiResource(
				"/conversation/" + object.toURLFragment()).get(
				new GenericType<List<Conversation>>() {
				});
	}

	/**
	 * Creates a reply to the conversation.
	 * 
	 * @param conversationId
	 *            The id of the conversation to reply to
	 * @param text
	 *            The text of the reply
	 * @return The id of the new message
	 */
	public int addReply(int conversationId, String text) {
		return getResourceFactory()
				.getApiResource("/conversation/" + conversationId + "/reply")
				.entity(new MessageCreate(text),
						MediaType.APPLICATION_JSON_TYPE)
				.get(MessageCreateResponse.class).getMessageId();
	}
}
