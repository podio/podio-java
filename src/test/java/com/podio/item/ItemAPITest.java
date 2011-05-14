package com.podio.item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.podio.APIFactoryProvider;
import com.podio.app.ApplicationFieldType;
import com.podio.common.AuthorizationEntityType;
import com.podio.common.Reference;
import com.podio.common.ReferenceType;
import com.podio.filter.CreatedByFilterBy;
import com.podio.filter.CreatedViaFilterBy;
import com.podio.filter.FilterByValue;
import com.podio.rating.RatingType;
import com.podio.rating.RatingValue;

public class ItemAPITest {

	private ItemAPI getAPI() {
		return APIFactoryProvider.getDefault().getItemAPI();
	}

	@Test
	public void addItem() {
		int itemId = getAPI().addItem(
				1,
				new ItemCreate(null, Arrays.asList(new FieldValuesUpdate(1,
						"value", "yes")), Collections.<Integer> emptyList(),
						Collections.<String> emptyList()), false);

		Assert.assertTrue(itemId > 1);
	}

	@Test
	public void addItemAsApp() {
		int itemId = APIFactoryProvider
				.getApp(1)
				.getItemAPI()
				.addItem(
						1,
						new ItemCreate(null,
								Arrays.asList(new FieldValuesUpdate(1, "value",
										"yes")), Collections
										.<Integer> emptyList(), Collections
										.<String> emptyList()), false);

		Assert.assertTrue(itemId > 1);
	}

	@Test
	public void updateItem() {
		getAPI().updateItem(
				1,
				new ItemUpdate(null, Arrays.asList(new FieldValuesUpdate(1,
						"value", "no"))), false);
	}

	@Test
	public void updateItemExternalId() {
		getAPI().updateItem(
				1,
				new ItemUpdate(null, Arrays.asList(new FieldValuesUpdate(
						"is-hired", "value", "no"))), false);
	}

	@Test
	public void updateItemValues() {
		getAPI().updateItemValues(1,
				Arrays.asList(new FieldValuesUpdate(1, "value", "no")), false);
	}

	@Test
	public void updateItemValuesExternalId() {
		getAPI().updateItemValues(
				1,
				Arrays.asList(new FieldValuesUpdate("is-hired", "value", "no")),
				false);
	}

	@Test
	public void updateItemFieldValues() {
		getAPI().updateItemFieldValues(
				1,
				1,
				Collections.singletonList(Collections
						.<String, Object> singletonMap("value", "no")), false);
	}

	@Test
	public void deleteItem() {
		getAPI().deleteItem(1, false);
	}

	@Test
	public void getItem() {
		Item item = getAPI().getItem(1);

		Assert.assertEquals(item.getId(), 1);
		Assert.assertEquals(item.getExternalId(), "12");
		Assert.assertEquals(item.getApplication().getId(), 1);
		Assert.assertEquals(item.getApplication().getName(), "Bugs");
		Assert.assertEquals(item.getApplication().getItemName(), "Bug");
		Assert.assertEquals(item.getApplication().getIcon(), "23.png");
		Assert.assertEquals(item.getFields().size(), 12);
		FieldValuesView field = item.getFields().get(0);
		Assert.assertEquals(field.getId(), 1);
		Assert.assertEquals(field.getExternalId(), "is-hired");
		Assert.assertEquals(field.getType(), ApplicationFieldType.STATE);
		Assert.assertEquals(field.getLabel(), "Is hired?");
		Assert.assertEquals(field.getValues().size(), 2);
		Assert.assertEquals(field.getValues().get(0).get("value"), "no");
		Assert.assertEquals(field.getValues().get(0).size(), 1);
		Assert.assertEquals(field.getValues().get(1).get("value"), "yes");
		Assert.assertEquals(field.getValues().get(1).size(), 1);
		Assert.assertEquals(item.getComments().size(), 2);
		Assert.assertEquals(item.getRevisions().size(), 1);
		Assert.assertEquals(item.getRatings().get(RatingType.APPROVED)
				.getCounts(1).getTotal(), 1);
		Assert.assertEquals(item.getRatings().get(RatingType.APPROVED)
				.getCounts(1).getUsers().get(0).getUserId().intValue(), 2);
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
	public void getItemValues() {
		List<FieldValuesView> values = getAPI().getItemValues(1);

		Assert.assertEquals(values.size(), 12);
		Assert.assertEquals(values.get(4).getValues().size(), 1);
		Assert.assertEquals(values.get(4).getValues().get(0).size(), 1);
		Assert.assertEquals(((Map<String, Object>) values.get(4).getValues()
				.get(0).get("value")).get("item_id"), 2);
		Assert.assertEquals(((Map<String, Object>) values.get(4).getValues()
				.get(0).get("value")).get("title"), "Bug 2");
	}

	@Test
	public void getItemFieldValues() {
		List<Map<String, Object>> values = getAPI().getItemFieldValues(1, 5);

		Assert.assertEquals(values.size(), 1);
		Assert.assertEquals(values.get(0).size(), 1);
		Assert.assertEquals(((Map<String, Object>) values.get(0).get("value"))
				.get("item_id"), 2);
		Assert.assertEquals(
				((Map<String, Object>) values.get(0).get("value")).get("title"),
				"Bug 2");
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
		Assert.assertEquals(item.getTitle(), "æøå");
	}

	@Test
	public void getItemRevision() {
		ItemRevision revision = getAPI().getItemRevision(1, 0);

		Assert.assertEquals(revision.getCreatedBy().getType(),
				AuthorizationEntityType.USER);
		Assert.assertEquals(revision.getCreatedBy().getId(), 1);
	}

	@Test
	public void getItemRevisionDifference() {
		List<ItemFieldDifference> differences = getAPI()
				.getItemRevisionDifference(2, 0, 1);

		Assert.assertEquals(differences.size(), 1);
		Assert.assertEquals(differences.get(0).getId(), 1);
		Assert.assertEquals(differences.get(0).getType(),
				ApplicationFieldType.STATE);
		Assert.assertEquals(differences.get(0).getLabel(), "Is hired?");
		Assert.assertEquals(differences.get(0).getFrom().size(), 1);
		Assert.assertEquals(differences.get(0).getFrom().get(0).get("value"),
				"yes");
		Assert.assertEquals(differences.get(0).getTo().size(), 1);
		Assert.assertEquals(differences.get(0).getTo().get(0).get("value"),
				"no");
	}

	@Test
	public void getItemRevisions() {
		List<ItemRevision> revisions = getAPI().getItemRevisions(2);

		Assert.assertEquals(revisions.size(), 2);
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
		ItemsResponse response = getAPI().getItemsByExternalId(1, "12");

		Assert.assertEquals(response.getItems().size(), 1);
		Assert.assertEquals(response.getItems().get(0).getId(), 1);
	}

	@Test
	public void getItemsFilterByCreatedBy() {
		ItemsResponse response = getAPI().getItems(
				1,
				null,
				null,
				null,
				null,
				new FilterByValue<List<Reference>>(new CreatedByFilterBy(),
						Arrays.asList(new Reference(ReferenceType.USER, 0))));

		Assert.assertEquals(response.getItems().size(), 1);
		Assert.assertEquals(response.getItems().get(0).getId(), 1);
	}

	@Test
	public void getItemsFilterByCreatedVia() {
		ItemsResponse response = getAPI().getItems(
				1,
				null,
				null,
				null,
				null,
				new FilterByValue<List<Integer>>(new CreatedViaFilterBy(),
						Arrays.asList(2)));

		Assert.assertEquals(response.getItems().size(), 1);
		Assert.assertEquals(response.getItems().get(0).getId(), 2);
	}

	@Test
	public void getItemsByFieldAndText() {
		List<ItemMini> items = getAPI().getItemsByFieldAndTitle(5, "bug");

		Assert.assertEquals(items.size(), 1);
		Assert.assertEquals(items.get(0).getId(), 2);
	}

	@Test
	public void getAppActivity() {
		AppActivities activities = getAPI().getAppActivities(1);

		Assert.assertEquals(activities.getToday().size(), 0);
		Assert.assertEquals(activities.getLastWeek().size(), 0);
	}

	@Test
	public void getNextItem() {
		ItemMicro item = getAPI().getNextItem(1);

		Assert.assertEquals(item.getId(), 2);
	}

	@Test
	public void getPreviousItem() {
		ItemMicro item = getAPI().getPreviousItem(2);

		Assert.assertEquals(item.getId(), 1);
	}
}
