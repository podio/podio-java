package com.podio.tag;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import com.podio.BaseAPIFactory;
import com.podio.common.Reference;
import com.podio.common.ReferenceType;

public class TagAPITest {

	private TagAPI getAPI() {
		return new TagAPI(BaseAPIFactory.get());
	}

	@Test
	public void createTags() {
		getAPI().createTags(new Reference(ReferenceType.ITEM, 1), "Tag1",
				"Tag2");
	}

	@Test
	public void updateTags() {
		getAPI().updateTags(new Reference(ReferenceType.ITEM, 1), "Tag1",
				"Tag2");
	}

	@Test
	public void removeTag() {
		getAPI().removeTag(new Reference(ReferenceType.ITEM, 1), "release");
	}

	@Test
	public void getTagsOnApp() {
		List<TagCount> tags = getAPI().getTagsOnApp(1);

		Assert.assertEquals(tags.size(), 3);
		Assert.assertEquals(tags.get(0).getText(), "problems");
		Assert.assertEquals(tags.get(0).getCount(), 1);
	}

	@Test
	public void getTagsOnSpace() {
		List<TagCount> tags = getAPI().getTagsOnSpace(1);

		Assert.assertEquals(tags.size(), 3);
		Assert.assertEquals(tags.get(0).getText(), "release");
		Assert.assertEquals(tags.get(0).getCount(), 2);
	}

	@Test
	public void getTagsOnAppWithText() {
		List<TagReference> references = getAPI().getTagsOnAppWithText(1,
				"problems");

		Assert.assertEquals(references.size(), 1);
		Assert.assertEquals(references.get(0).getReferenceType(),
				ReferenceType.ITEM);
		Assert.assertEquals(references.get(0).getReferenceId(), 2);
		Assert.assertEquals(references.get(0).getTitle(), "Bug 2");
		Assert.assertEquals(references.get(0).getCreatedOn(), new DateTime(
				2010, 8, 5, 10, 12, 0, 0));
		Assert.assertEquals(references.get(0).getLink(),
				"https://hoist.podio.com/api/item/2");
	}

	@Test
	public void getTagsOnSpaceWithText() {
		List<TagReference> references = getAPI().getTagsOnSpaceWithText(1,
				"release");

		Assert.assertEquals(references.size(), 2);
		Assert.assertEquals(references.get(0).getReferenceType(),
				ReferenceType.STATUS);
		Assert.assertEquals(references.get(0).getReferenceId(), 1);
		Assert.assertEquals(
				references.get(0).getTitle(),
				"This is going to be legen- wait for it -dary. @Andreas Haugstrup Now it's up to you to make it ha...");
		Assert.assertEquals(references.get(0).getCreatedOn(), new DateTime(
				2010, 8, 12, 17, 9, 0, 0));
		Assert.assertEquals(references.get(0).getLink(),
				"https://hoist.podio.com/api/status/1");
		Assert.assertEquals(references.get(1).getReferenceType(),
				ReferenceType.ITEM);
		Assert.assertEquals(references.get(1).getReferenceId(), 1);
		Assert.assertEquals(references.get(1).getTitle(), "זרו");
		Assert.assertEquals(references.get(1).getCreatedOn(), new DateTime(
				2010, 8, 2, 16, 0, 0, 0));
		Assert.assertEquals(references.get(1).getLink(),
				"https://hoist.podio.com/api/item/1");
	}
}
