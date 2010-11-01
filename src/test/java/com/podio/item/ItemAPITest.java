package com.podio.item;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

import com.podio.BaseAPIFactory;

public class ItemAPITest {

	private ItemAPI getAPI() {
		return new ItemAPI(BaseAPIFactory.get());
	}

	@Test
	public void addItem() {
		ItemCreateResponse response = getAPI().addItem(
				1,
				new ItemCreate(null, Arrays.asList(new FieldValues(1, "value",
						"yes")), null, null));

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
	}
}
