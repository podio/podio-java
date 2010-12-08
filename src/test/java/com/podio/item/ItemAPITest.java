package com.podio.item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.podio.BaseAPIFactory;
import com.podio.app.ApplicationFieldType;
import com.podio.rating.RatingType;
import com.podio.rating.RatingValue;

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
						.<String> emptyList()), false);

		Assert.assertTrue(response.getItemId() > 1);
	}

	@Test
	public void updateItem() {
		getAPI().updateItem(
				1,
				new ItemUpdate(null, Arrays.asList(new FieldValues(1, "value",
						"no"))), false);
	}

	@Test
	public void deleteItem() {
		getAPI().deleteItem(1, false);
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
		Assert.assertEquals(item.getFields().size(), 10);
		FieldValues field = item.getFields().get(0);
		Assert.assertEquals(field.getId(), 1);
		Assert.assertEquals(field.getType(), ApplicationFieldType.STATE);
		Assert.assertEquals(field.getLabel(), "Is hired?");
		Assert.assertEquals(field.getValues().size(), 2);
		Assert.assertEquals(field.getValues().get(0).get("value"), "yes");
		Assert.assertEquals(field.getValues().get(0).size(), 1);
		Assert.assertEquals(field.getValues().get(1).get("value"), "no");
		Assert.assertEquals(field.getValues().get(1).size(), 1);
		Assert.assertEquals(item.getComments().size(), 2);
		Assert.assertEquals(item.getRevisions().size(), 1);
		Assert.assertEquals(item.getRatings().get(RatingType.APPROVED)
				.getCounts(1).getTotal(), 1);
		Assert.assertEquals(item.getRatings().get(RatingType.APPROVED)
				.getCounts(1).getUsers().get(0).getId(), 2);
		// Assert.assertEquals(item.getConversations().size(), 1);
		// Assert.assertEquals(item.getConversations().get(0).getId(), 1);
		// Assert.assertEquals(
		// item.getConversations().get(0).getMessages().size(), 2);
		Assert.assertEquals(item.getTasks().size(), 1);
		Assert.assertEquals(item.getTasks().get(0).getId(), 4);
		// Assert.assertEquals(item.getShares().size(), 1);
		// Assert.assertEquals(item.getShares().get(0).getUser().getId(), 4);
		Assert.assertEquals(item.getFiles().size(), 1);
		Assert.assertEquals(item.getFiles().get(0).getId(), 1);
		Assert.assertEquals(item.getReferences().size(), 0);
		Assert.assertEquals(item.getTags().size(), 2);
		Assert.assertEquals(item.getTags().get(0), "release");
		Assert.assertEquals(item.getTags().get(1), "rollout");
		Assert.assertEquals(item.isSubscribed(), true);
		Assert.assertEquals(item.getUserRatings().size(), 4);
		Assert.assertEquals(item.getUserRating(RatingType.APPROVED),
				new Integer(RatingValue.APPROVED_APPROVES));
		Assert.assertEquals(item.getUserRating(RatingType.FIVESTAR),
				new Integer(RatingValue.FIVESTAR_1_STAR));
		Assert.assertEquals(item.getUserRating(RatingType.YESNO), new Integer(
				RatingValue.YESNO_YES));
		Assert.assertEquals(item.getUserRating(RatingType.RSVP), new Integer(
				RatingValue.RSVP_ATTEND));
	}

	@Test
	public void getItemReferences() {
		List<ItemReference> references = getAPI().getItemReference(2);

		Assert.assertEquals(references.size(), 1);
		ItemReference reference = references.get(0);
		Assert.assertEquals(reference.getApplication().getId(), 1);
		Assert.assertEquals(reference.getItems().size(), 1);
		ItemMicro item = reference.getItems().get(0);
		Assert.assertEquals(item.getId(), 1);
		Assert.assertEquals(item.getTitle(), "זרו");
	}

	@Test
	public void getItems() {
		ItemsResponse response = getAPI().getItems(1, null, null, null, null);

		Assert.assertEquals(response.getTotal(), 2);
		Assert.assertEquals(response.getFiltered(), 2);
		Assert.assertEquals(response.getItems().size(), 2);
	}

	@Test
	public void getItemsByExternalId() {
		ItemsResponse response = getAPI().getItemsByExternalId(1,
				"Foo generator");

		Assert.assertEquals(response.getItems().size(), 1);
		Assert.assertEquals(response.getItems().get(0).getId(), 1);
	}
}
