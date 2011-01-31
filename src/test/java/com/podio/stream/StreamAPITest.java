package com.podio.stream;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

import com.podio.APIFactoryProvider;
import com.podio.common.Reference;
import com.podio.common.ReferenceType;

public class StreamAPITest {

	private StreamAPI getAPI() {
		return APIFactoryProvider.getDefault().getStreamAPI();
	}

	@Test
	public void getStreamObject() {
		StreamObject object = getAPI().getStreamObject(
				new Reference(ReferenceType.ITEM, 1));

		Assert.assertEquals(object.getType(), ReferenceType.ITEM);
		Assert.assertEquals(object.getId(), 1);
		Assert.assertEquals(object.getLink(),
				"https://hoist.podio.com/api/item/1");
		Assert.assertEquals(object.getComments().size(), 2);
		Assert.assertEquals(object.getComments().get(0).getId(), 1);
		Assert.assertEquals(object.getFiles().size(), 2);
		Assert.assertEquals(object.getFiles().get(0).getId(), 8);
		Assert.assertEquals(object.getFiles().get(1).getId(), 1);
		Assert.assertEquals(object.getObject().get("item_id"), 1);
		Assert.assertEquals(object.getOrganization().getId(), 1);
		Assert.assertEquals(object.getRatings().size(), 0);
		Assert.assertEquals(object.getRevisions().size(), 0);
		Assert.assertEquals(object.getSpace().getId(), 1);
	}

	@Test
	public void getGlobalStream() {
		List<StreamObject> objects = getAPI().getGlobalStream(3, 1,
				new DateTime(2010, 10, 4, 12, 0, 0, 0, DateTimeZone.UTC));

		Assert.assertEquals(objects.size(), 3);
		Assert.assertEquals(objects.get(0).getType(), ReferenceType.STATUS);
		Assert.assertEquals(objects.get(0).getId(), 1);
	}

	@Test
	public void getOrganizationStream() {
		List<StreamObject> objects = getAPI().getOrganizationStream(1, 3, 1,
				new DateTime(2010, 10, 4, 12, 0, 0, 0, DateTimeZone.UTC));

		Assert.assertEquals(objects.size(), 3);
		Assert.assertEquals(objects.get(0).getType(), ReferenceType.STATUS);
		Assert.assertEquals(objects.get(0).getId(), 1);
	}

	@Test
	public void getSpaceStream() {
		List<StreamObject> objects = getAPI().getSpaceStream(1, 3, 1,
				new DateTime(2010, 10, 4, 12, 0, 0, 0, DateTimeZone.UTC));

		Assert.assertEquals(objects.size(), 3);
		Assert.assertEquals(objects.get(0).getType(), ReferenceType.STATUS);
		Assert.assertEquals(objects.get(0).getId(), 1);
	}
}
