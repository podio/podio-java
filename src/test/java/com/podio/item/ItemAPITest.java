package com.podio.item;

import java.util.Arrays;
import java.util.Collections;

import junit.framework.Assert;

import org.junit.Test;

import com.podio.BaseAPIFactory;
import com.podio.rating.RatingType;

public class ItemAPITest {

	private ItemAPI getAPI() {
		return new ItemAPI(BaseAPIFactory.get());
	}

	@Test
	public void addItem() {
		ItemCreateResponse response = getAPI().addItem(
				1,
				new ItemCreate(null, Arrays.asList(new FieldValues(1, "value",
						"yes")), Collections.<Integer> emptyList(), Collections
						.<String> emptyList()));

		Assert.assertTrue(response.getItemId() > 1);
	}

	@Test
	public void getItem() {
		Item item = getAPI().getItem(1);

		Assert.assertEquals(item.getId(), 1);
		Assert.assertEquals(item.getExternalId(), "Foo generator");
		Assert.assertEquals(item.getApplication().getId(), 1);
		Assert.assertEquals(item.getApplication().getName(), "Bugs");
		Assert.assertEquals(item.getApplication().getItemName(), "Bug");
		Assert.assertEquals(item.getApplication().getIcon(), "23.png");
		Assert.assertEquals(item.getComments().size(), 2);
		Assert.assertEquals(item.getRevisions().size(), 1);
		Assert.assertEquals(item.getRatings().get(RatingType.APPROVED)
				.getCounts(1).getTotal(), 1);
		Assert.assertEquals(item.getRatings().get(RatingType.APPROVED)
				.getCounts(1).getUsers().get(0).getId(), 2);
		Assert.assertEquals(item.getConversations().size(), 1);
		Assert.assertEquals(item.getConversations().get(0).getId(), 1);
		Assert.assertEquals(
				item.getConversations().get(0).getMessages().size(), 2);
	}
}
