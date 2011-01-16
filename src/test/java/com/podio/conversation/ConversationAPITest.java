package com.podio.conversation;

import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

import com.podio.ResourceFactoryProvider;
import com.podio.common.Reference;
import com.podio.common.ReferenceType;

public class ConversationAPITest {

	private ConversationAPI getAPI() {
		return new ConversationAPI(ResourceFactoryProvider.getDefault());
	}

	@Test
	public void createConversation() {
		int conversationId = getAPI().createConversation("Subject", "Message",
				Arrays.asList(2, 3));

		Assert.assertTrue(conversationId > 1);
	}

	@Test
	public void createConversationOnObject() {
		int conversation_id = getAPI().createConversation("Subject", "Message",
				Arrays.asList(2, 3), new Reference(ReferenceType.ITEM, 1));

		Assert.assertTrue(conversation_id > 1);
	}

	@Test
	public void getConversation() {
		Conversation conversation = getAPI().getConversation(1);

		Assert.assertEquals(conversation.getId(), 1);
		Assert.assertEquals(conversation.getSubject(),
				"Isn't all these notification types annoying?");
		Assert.assertEquals(conversation.getMessages().size(), 2);
		Message message = conversation.getMessages().get(0);
		Assert.assertEquals(message.getId(), 1);
		Assert.assertEquals(
				message.getText(),
				"They are really getting on my nerves.\n\nCan we not get this sorted out better?!?");
		Assert.assertEquals(message.getCreatedOn(), new DateTime(2010, 8, 25,
				14, 26, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(message.getCreatedBy().getId(), 1);
		Assert.assertEquals(conversation.getParticipants().size(), 2);
		Assert.assertEquals(conversation.getParticipants().get(0).getId(), 1);
		Assert.assertEquals(conversation.getParticipants().get(1).getId(), 2);
	}

	@Test
	public void getConversationsOnObject() {
		List<Conversation> conversations = getAPI().getConversationsOnObject(
				new Reference(ReferenceType.ITEM, 1));

		Assert.assertEquals(conversations.size(), 1);
		Assert.assertEquals(conversations.get(0).getId(), 1);
	}

	@Test
	public void addReply() {
		int messageId = getAPI().addReply(1, "My reply");

		Assert.assertTrue(messageId > 1);
	}
}
