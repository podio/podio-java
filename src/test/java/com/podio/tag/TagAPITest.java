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
}
