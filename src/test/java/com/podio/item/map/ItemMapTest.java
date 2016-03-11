package com.podio.item.map;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Test;

import com.podio.APIFactoryProvider;
import com.podio.app.AppAPI;
import com.podio.app.Application;
import com.podio.item.FieldValuesUpdate;
import com.podio.item.Item;
import com.podio.item.ItemAPI;
import com.podio.item.ItemCreate;
import com.podio.item.ItemUpdate;

public class ItemMapTest {

	@Test
	public void mapTest1() {
		ItemCreate create = getCreate(
				1,
				new BugMap1(1, Collections.singleton(HireStatus.YES), Money.of(
						CurrencyUnit.EUR, new BigDecimal("123.45")),
						"A mexican in a bar", new BigDecimal("1.2"), 30,
						"Ignored"));
		Assert.assertEquals(create.getExternalId(), "1");
		checkValue(create.getFields(), "is-hired", 0, "value", 1);
		checkValue(create.getFields(), "alotta-cash", 0, "value", "123.45");
		checkValue(create.getFields(), "alotta-cash", 0, "currency", "EUR");
		checkValue(create.getFields(), "write-a-joke", 0, "value",
				"A mexican in a bar");
		checkValue(create.getFields(), "importance", 0, "value", "1.2");
		checkValue(create.getFields(), "how-far-are-we", 0, "value", 30);
		Assert.assertEquals(create.getFileIds().size(), 0);
		Assert.assertEquals(create.getTags().size(), 0);

		BugMap1 model = getView(1, 1, BugMap1.class);
		Assert.assertEquals(model.getExternalId(), 12);
		Assert.assertTrue(model.getStatuses().contains(HireStatus.YES));
		Assert.assertEquals(model.getAlottaCash().getAmount(), new BigDecimal(
				"256.50"));
		Assert.assertEquals(model.getAlottaCash().getCurrencyUnit()
				.getCurrencyCode(), "DKK");
		Assert.assertEquals(model.getWriteAJoke(), "<p>æøå</p><p><img src=\"https://files.podio.com/1000\" /></p>");
		Assert.assertEquals(model.getImportance(), new BigDecimal("2.2000"));
		Assert.assertEquals(model.getHowFarAreWe(), 15);
	}

	@Test
	public void mapTest2() {
		ItemCreate create = getCreate(1,
				new BugMap2(2, Collections.singletonList("yes"),
						new BigDecimal("123.45"), 1.2d, (short) 30));
		Assert.assertEquals(create.getExternalId(), "2");
		checkValue(create.getFields(), "is-hired", 0, "value", 1);
		checkValue(create.getFields(), "alotta-cash", 0, "value", "123.45");
		checkValue(create.getFields(), "alotta-cash", 0, "currency", "DKK");
		checkValue(create.getFields(), "importance", 0, "value", "1.2");
		checkValue(create.getFields(), "how-far-are-we", 0, "value", 30);
		Assert.assertEquals(create.getFileIds().size(), 0);
		Assert.assertEquals(create.getTags().size(), 0);

		BugMap2 model = getView(1, 1, BugMap2.class);
		Assert.assertEquals(model.getExternalId(), 12);
		Assert.assertTrue(model.getStatuses().contains("yes"));
		Assert.assertEquals(model.getAlottaCash(), new BigDecimal("256.5000"));
		Assert.assertEquals(model.getImportance(), 2.2d, 0);
		Assert.assertEquals(model.getHowFarAreWe(), new Short((short) 15));
	}

	@Test
	public void mapTest3() {
		ItemCreate create = getCreate(1,
				new BugMap3("3", Collections.singleton("yes"), 123.45, 1.2f));
		Assert.assertEquals(create.getExternalId(), "3");
		checkValue(create.getFields(), "is-hired", 0, "value", 1);
		checkValue(create.getFields(), "alotta-cash", 0, "value", "123.45");
		checkValue(create.getFields(), "alotta-cash", 0, "currency", "EUR");
		checkValue(create.getFields(), "importance", 0, "value", "1.2");
		Assert.assertEquals(create.getFileIds().size(), 0);
		Assert.assertEquals(create.getTags().size(), 0);

		BugMap3 model = getView(1, 1, BugMap3.class);
		Assert.assertEquals(model.getExternalId(), "12");
		Assert.assertTrue(model.getStatuses().contains("yes"));
		Assert.assertEquals(model.getAmount(), 256.5, 0);
		Assert.assertEquals(model.getImportance(), 2.2f, 0);
	}

	private <T> ItemMap<T> getMap(int appId, Class<? extends Object> cls) {
		Application application = APIFactoryProvider.getDefault()
				.getAPI(AppAPI.class).getApp(appId);

		ItemMap<T> itemMap = (ItemMap<T>) ItemMap.get(application, cls);
		return itemMap;
	}

	private <T> ItemCreate getCreate(int appId, T value) {
		return getMap(appId, value.getClass()).getCreate(value);
	}

	private <T> ItemUpdate getUpdate(int appId, T value) {
		return getMap(appId, value.getClass()).getUpdate(value);
	}

	private <T> T getView(int appId, int itemId, Class<T> cls) {
		Item item = APIFactoryProvider.getDefault().getAPI(ItemAPI.class)
				.getItem(itemId);

		return (T) getMap(appId, cls).getView(item);
	}

	private void checkValue(List<FieldValuesUpdate> updates, String externalId,
			int delta, String key, Object value) {
		for (FieldValuesUpdate update : updates) {
			if (update.getExternalId().equals(externalId)) {
				Assert.assertEquals(update.getValues().get(delta).get(key),
						value);
				return;
			}
		}

		Assert.fail("No field found with external id " + externalId);
	}
}
