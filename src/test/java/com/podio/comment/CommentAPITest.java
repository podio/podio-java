package com.podio.comment;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

import com.podio.BaseAPIFactory;
import com.podio.common.Reference;
import com.podio.common.ReferenceType;

public class CommentAPITest {

	private CommentAPI getAPI() {
		return new CommentAPI(BaseAPIFactory.get());
	}

	@Test
	public void getComment() {
		Comment comment = getAPI().getComment(1);

		Assert.assertEquals(comment.getId(), 1);
		Assert.assertEquals(
				comment.getValue(),
				"Hoist rules, but we need to do more.<br />@Andreas Haugstrup Can you fix the javascript popup problem?");
		Assert.assertEquals(comment.getExternalId(), "c1");
		Assert.assertEquals(comment.getAlerts().size(), 1);
		Assert.assertEquals(comment.getAlerts().get(0).getId(), 2);
		Assert.assertEquals(comment.getCreatedOn(), new DateTime(2010, 8, 5, 9,
				8, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(comment.getFiles().size(), 0);
		Assert.assertEquals(comment.getUser().getId(), 1);
	}

	@Test
	public void getComments() {
		List<Comment> comments = getAPI().getComments(
				new Reference(ReferenceType.ITEM, 1));

		Assert.assertEquals(comments.size(), 2);
		Assert.assertEquals(comments.get(0).getId(), 1);
	}

	@Test
	public void addComment() {
		int commentId = getAPI().addComment(
				new Reference(ReferenceType.ITEM, 1),
				new CommentCreate("Testing"), false);

		Assert.assertTrue(commentId > 5);
	}

	@Test
	public void updateComment() {
		getAPI().updateComment(1, new CommentUpdate("Test"));
	}

	@Test
	public void deleteComment() {
		getAPI().deleteComment(1);
	}
}
