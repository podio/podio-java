package com.podio.comment;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

import com.podio.APIFactoryProvider;
import com.podio.common.AuthorizationEntityType;
import com.podio.common.AvatarType;
import com.podio.common.Reference;
import com.podio.common.ReferenceType;

public class CommentAPITest {

	private CommentAPI getAPI() {
		return APIFactoryProvider.getDefault().getAPI(CommentAPI.class);
	}

	@Test
	public void getComment() {
		Comment comment = getAPI().getComment(1);

		Assert.assertEquals(comment.getId(), 1);
		Assert.assertEquals(
				comment.getValue(),
				"Hoist rules, but we need to do more.\n\n@Andreas Haugstrup Can you fix the javascript popup problem?");
		Assert.assertEquals(comment.getExternalId(), "c1");
		// Assert.assertEquals(comment.getAlerts().size(), 1);
		// Assert.assertEquals(comment.getAlerts().get(0).getId(), 2);
		Assert.assertEquals(comment.getCreatedOn(), new DateTime(2010, 8, 5, 9,
				8, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(comment.getFiles().size(), 0);
		Assert.assertEquals(comment.getCreatedBy().getId(), 1);
		Assert.assertEquals(comment.getCreatedBy().getType(),
				AuthorizationEntityType.USER);
		Assert.assertEquals(comment.getCreatedBy().getName(), "Christian Holm");
		Assert.assertEquals(comment.getCreatedBy().getAvatarType(),
				AvatarType.FILE);
		Assert.assertEquals(comment.getCreatedBy().getAvatarId().intValue(), 9);
		Assert.assertEquals(comment.getCreatedBy().getUrl().toString(),
				"https://podio.com/users/1");
		Assert.assertEquals(comment.getCreatedVia().getId(), 1);
		Assert.assertEquals(comment.getCreatedVia().getName(), "Podio Web");
		Assert.assertEquals(comment.getCreatedVia().getUrl(), null);
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
				new CommentCreate("Testing"), false, false);

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
