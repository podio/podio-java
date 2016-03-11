package com.podio.item.map;

import java.math.BigDecimal;
import java.util.Collections;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Test;

import com.podio.APIFactoryProvider;

public class MappedItemAPITest {

	private <T> MappedItemAPI<T> getMappedAPI(Class<T> cls) {
		return new MappedItemAPI<T>(APIFactoryProvider.getDefault(), 1, cls);
	}

	@Test
	public void getItem() {
		BugMap1 bug = getMappedAPI(BugMap1.class).get(12);

		Assert.assertEquals(bug.getExternalId(), 12);
		Assert.assertTrue(bug.getStatuses().contains(HireStatus.YES));
		Assert.assertEquals(bug.getAlottaCash().getAmount(), new BigDecimal(
				"256.50"));
		Assert.assertEquals(bug.getAlottaCash().getCurrencyUnit()
				.getCurrencyCode(), "DKK");
		Assert.assertEquals(bug.getWriteAJoke(), "<p>æøå</p><p><img src=\"https://files.podio.com/1000\" /></p>");
		Assert.assertEquals(bug.getImportance(), new BigDecimal("2.2000"));
		Assert.assertEquals(bug.getHowFarAreWe(), 15);
	}

	@Test
	public void createItem() {
		BugMap1 bug = new BugMap1(1, Collections.singleton(HireStatus.YES),
				Money.of(CurrencyUnit.EUR, new BigDecimal("123.45")),
				"A mexican in a bar", new BigDecimal("1.2"), 30, "Ignored");
		int itemId = getMappedAPI(BugMap1.class).insert(bug, true);
		Assert.assertTrue(itemId > 0);
	}
}
