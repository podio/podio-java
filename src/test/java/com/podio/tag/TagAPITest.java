package com.podio.tag;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

import com.podio.APIFactoryProvider;
import com.podio.common.Reference;
import com.podio.common.ReferenceType;

public class TagAPITest {

	private TagAPI getAPI() {
		return APIFactoryProvider.getDefault().getAPI(TagAPI.class);
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
		Assert.assertEquals(tags.get(0).getText(), "problems");
		Assert.assertEquals(tags.get(0).getCount(), 1);
	}

	@Test
	public void getTagsOnAppWithText() {
		List<TagReference> references = getAPI().getTagsOnAppWithText(1,
				"problems");

		Assert.assertEquals(references.size(), 1);
		Assert.assertEquals(references.get(0).getType(), ReferenceType.ITEM);
		Assert.assertEquals(references.get(0).getId(), 2);
		Assert.assertEquals(references.get(0).getTitle(),
				"no");
		Assert.assertEquals(references.get(0).getCreatedOn(), new DateTime(
				2010, 8, 5, 10, 12, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(references.get(0).getLink(),
				"https://podio.com/hoist/api/apps/bugs/items/2");
	}

	@Test
	public void getTagsOnSpaceWithText() {
		List<TagReference> references = getAPI().getTagsOnSpaceWithText(1,
				"release");

		Assert.assertEquals(references.size(), 1);
		TagReference reference = references.get(0);
		Assert.assertEquals(reference.getType(), ReferenceType.ITEM);
		Assert.assertEquals(reference.getId(), 1);
		Assert.assertEquals(reference.getTitle(), "no & yes");
		Assert.assertEquals(reference.getCreatedOn(), new DateTime(2010, 8, 2,
				16, 0, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(reference.getLink(),
				"https://podio.com/hoist/api/apps/bugs/items/1");
	}
}
