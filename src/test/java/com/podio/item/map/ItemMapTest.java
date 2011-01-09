package com.podio.item.map;

import java.math.BigDecimal;
import java.util.List;

import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Test;

import com.podio.APIFactoryProvider;
import com.podio.app.Application;
import com.podio.item.FieldValuesUpdate;
import com.podio.item.Item;
import com.podio.item.ItemCreate;
import com.podio.item.ItemUpdate;

public class ItemMapTest {

	@Test
	public void mapTest1() {
		ItemCreate create = getCreate(1,
				new Test1(1, Money.of("EUR", new BigDecimal("123.45")),
						"Ignored"));
		Assert.assertEquals(create.getExternalId(), "1");
		checkValue(create.getFields(), "alotta-cash", 0, "value", "123.45");
		checkValue(create.getFields(), "alotta-cash", 0, "currency", "EUR");
		Assert.assertEquals(create.getFileIds().size(), 0);
		Assert.assertEquals(create.getTags().size(), 0);

		Test1 model = getView(1, 1, Test1.class);
		Assert.assertEquals(model.getExternalId(), 12);
		Assert.assertEquals(model.getAlottaCash().getAmount(), new BigDecimal(
				"256.50"));
		Assert.assertEquals(model.getAlottaCash().getCurrencyUnit()
				.getCurrencyCode(), "DKK");
	}

	@Test
	public void mapTest2() {
		ItemCreate create = getCreate(1, new Test2(2, new BigDecimal("123.45")));
		Assert.assertEquals(create.getExternalId(), "2");
		checkValue(create.getFields(), "alotta-cash", 0, "value", "123.45");
		checkValue(create.getFields(), "alotta-cash", 0, "currency", "DKK");
		Assert.assertEquals(create.getFileIds().size(), 0);
		Assert.assertEquals(create.getTags().size(), 0);
	}

	@Test
	public void mapTest3() {
		ItemCreate create = getCreate(1, new Test3("3",
				new BigDecimal("123.45")));
		Assert.assertEquals(create.getExternalId(), "3");
		checkValue(create.getFields(), "alotta-cash", 0, "value", "123.45");
		checkValue(create.getFields(), "alotta-cash", 0, "currency", "EUR");
		Assert.assertEquals(create.getFileIds().size(), 0);
		Assert.assertEquals(create.getTags().size(), 0);
	}

	private <T> ItemMap<T> getMap(int appId, Class<? extends Object> cls) {
		Application application = APIFactoryProvider.get().getAppAPI()
				.getApp(appId);

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
		Item item = APIFactoryProvider.get().getItemAPI().getItem(itemId);

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

	public static class Test1 {

		private int externalId;

		private Money alottaCash;

		private String ignored;

		public Test1() {
			super();
		}

		public Test1(int externalId, Money alottaCash, String ignored) {
			super();
			this.externalId = externalId;
			this.alottaCash = alottaCash;
			this.ignored = ignored;
		}

		@ExternalId
		public int getExternalId() {
			return externalId;
		}

		public void setExternalId(int externalId) {
			this.externalId = externalId;
		}

		public Money getAlottaCash() {
			return alottaCash;
		}

		public void setAlottaCash(Money money) {
			this.alottaCash = money;
		}

		@Transient
		public String getIgnored() {
			return ignored;
		}

		public void setIgnored(String ignored) {
			this.ignored = ignored;
		}
	}

	public static class Test2 {

		private long externalId;

		private BigDecimal alottaCash;

		public Test2() {
			super();
		}

		public Test2(long externalId, BigDecimal alottaCash) {
			super();
			this.externalId = externalId;
			this.alottaCash = alottaCash;
		}

		@ExternalId
		public long getExternalId() {
			return externalId;
		}

		public void setExternalId(long externalId) {
			this.externalId = externalId;
		}

		public BigDecimal getAlottaCash() {
			return alottaCash;
		}

		public void setAlottaCash(BigDecimal amount) {
			this.alottaCash = amount;
		}
	}

	public static class Test3 {

		private String externalId;

		private BigDecimal amount;

		public Test3() {
			super();
		}

		public Test3(String externalId, BigDecimal amount) {
			super();
			this.externalId = externalId;
			this.amount = amount;
		}

		@ExternalId
		public String getExternalId() {
			return externalId;
		}

		public void setExternalId(String externalId) {
			this.externalId = externalId;
		}

		@MoneyField(currency = "EUR")
		@Field("alotta-cash")
		public BigDecimal getAmount() {
			return amount;
		}

		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}
	}
}
