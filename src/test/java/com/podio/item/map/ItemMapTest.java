package com.podio.item.map;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
		ItemCreate create = getCreate(
				1,
				new Test1(1, Collections.singleton(HireStatus.YES), Money.of(
						"EUR", new BigDecimal("123.45")),
						new BigDecimal("1.2"), "Ignored"));
		Assert.assertEquals(create.getExternalId(), "1");
		checkValue(create.getFields(), "is-hired", 0, "value", "yes");
		checkValue(create.getFields(), "alotta-cash", 0, "value", "123.45");
		checkValue(create.getFields(), "alotta-cash", 0, "currency", "EUR");
		checkValue(create.getFields(), "importance", 0, "value", "1.2");
		Assert.assertEquals(create.getFileIds().size(), 0);
		Assert.assertEquals(create.getTags().size(), 0);

		Test1 model = getView(1, 1, Test1.class);
		Assert.assertEquals(model.getExternalId(), 12);
		Assert.assertTrue(model.getStatuses().contains(HireStatus.YES));
		Assert.assertEquals(model.getAlottaCash().getAmount(), new BigDecimal(
				"256.50"));
		Assert.assertEquals(model.getAlottaCash().getCurrencyUnit()
				.getCurrencyCode(), "DKK");
	}

	@Test
	public void mapTest2() {
		ItemCreate create = getCreate(1,
				new Test2(2, Collections.singletonList("yes"), new BigDecimal(
						"123.45"), 1.2d));
		Assert.assertEquals(create.getExternalId(), "2");
		checkValue(create.getFields(), "is-hired", 0, "value", "yes");
		checkValue(create.getFields(), "alotta-cash", 0, "value", "123.45");
		checkValue(create.getFields(), "alotta-cash", 0, "currency", "DKK");
		checkValue(create.getFields(), "importance", 0, "value", "1.2");
		Assert.assertEquals(create.getFileIds().size(), 0);
		Assert.assertEquals(create.getTags().size(), 0);

		Test2 model = getView(1, 1, Test2.class);
		Assert.assertEquals(model.getExternalId(), 12);
		Assert.assertTrue(model.getStatuses().contains("yes"));
		Assert.assertEquals(model.getAlottaCash(), new BigDecimal("256.5000"));
	}

	@Test
	public void mapTest3() {
		ItemCreate create = getCreate(1,
				new Test3("3", Collections.singleton("yes"), 123.45, 1.2f));
		Assert.assertEquals(create.getExternalId(), "3");
		checkValue(create.getFields(), "is-hired", 0, "value", "yes");
		checkValue(create.getFields(), "alotta-cash", 0, "value", "123.45");
		checkValue(create.getFields(), "alotta-cash", 0, "currency", "EUR");
		checkValue(create.getFields(), "importance", 0, "value", "1.2");
		Assert.assertEquals(create.getFileIds().size(), 0);
		Assert.assertEquals(create.getTags().size(), 0);

		Test3 model = getView(1, 1, Test3.class);
		Assert.assertEquals(model.getExternalId(), "12");
		Assert.assertTrue(model.getStatuses().contains("yes"));
		Assert.assertEquals(model.getAmount(), 256.5, 0);
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

		private Set<HireStatus> statuses;

		private Money alottaCash;

		private BigDecimal importance;

		private String ignored;

		public Test1() {
			super();
		}

		public Test1(int externalId, Set<HireStatus> statuses,
				Money alottaCash, BigDecimal importance, String ignored) {
			super();
			this.externalId = externalId;
			this.statuses = statuses;
			this.alottaCash = alottaCash;
			this.importance = importance;
			this.ignored = ignored;
		}

		@ExternalId
		public int getExternalId() {
			return externalId;
		}

		public void setExternalId(int externalId) {
			this.externalId = externalId;
		}

		@Field("is-hired")
		public Set<HireStatus> getStatuses() {
			return statuses;
		}

		public void setStatuses(Set<HireStatus> statuses) {
			this.statuses = statuses;
		}

		public Money getAlottaCash() {
			return alottaCash;
		}

		public void setAlottaCash(Money money) {
			this.alottaCash = money;
		}

		public BigDecimal getImportance() {
			return importance;
		}

		public void setImportance(BigDecimal importance) {
			this.importance = importance;
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

		private List<String> statuses;

		private BigDecimal alottaCash;

		private double importance;

		public Test2() {
			super();
		}

		public Test2(long externalId, List<String> statuses,
				BigDecimal alottaCash, double importance) {
			super();
			this.externalId = externalId;
			this.statuses = statuses;
			this.alottaCash = alottaCash;
			this.importance = importance;
		}

		@ExternalId
		public long getExternalId() {
			return externalId;
		}

		public void setExternalId(long externalId) {
			this.externalId = externalId;
		}

		@Field("is-hired")
		public List<String> getStatuses() {
			return statuses;
		}

		public void setStatuses(List<String> statuses) {
			this.statuses = statuses;
		}

		public BigDecimal getAlottaCash() {
			return alottaCash;
		}

		public void setAlottaCash(BigDecimal amount) {
			this.alottaCash = amount;
		}

		public double getImportance() {
			return importance;
		}

		public void setImportance(double importance) {
			this.importance = importance;
		}
	}

	public static class Test3 {

		private String externalId;

		private Collection<String> statuses;

		private double amount;

		private float importance;

		public Test3() {
			super();
		}

		public Test3(String externalId, Collection<String> statuses,
				double amount, float importance) {
			super();
			this.externalId = externalId;
			this.statuses = statuses;
			this.amount = amount;
			this.importance = importance;
		}

		@ExternalId
		public String getExternalId() {
			return externalId;
		}

		public void setExternalId(String externalId) {
			this.externalId = externalId;
		}

		@Field("is-hired")
		public Collection<String> getStatuses() {
			return statuses;
		}

		public void setStatuses(Collection<String> statuses) {
			this.statuses = statuses;
		}

		@MoneyField(currency = "EUR")
		@Field("alotta-cash")
		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public float getImportance() {
			return importance;
		}

		public void setImportance(float importance) {
			this.importance = importance;
		}
	}
}
