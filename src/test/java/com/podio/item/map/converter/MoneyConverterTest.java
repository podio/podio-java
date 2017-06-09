package com.podio.item.map.converter;

import java.math.BigDecimal;
import java.util.Map;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Test;

public class MoneyConverterTest {

	@Test
	public void fromModel() {
		MoneyConverter converter = new MoneyConverter(CurrencyUnit.of("DKK"));

		Map<String, ?> result = converter.fromModel(Money.of(
				CurrencyUnit.of("EUR"), new BigDecimal("123.45")));
		Assert.assertEquals(result.get("value"), "123.45");
		Assert.assertEquals(result.get("currency"), "EUR");

		result = converter.fromModel(new BigDecimal("123.45"));
		Assert.assertEquals(result.get("value"), "123.45");
		Assert.assertEquals(result.get("currency"), "DKK");

		result = converter.fromModel(123l);
		Assert.assertEquals(result.get("value"), "123");
		Assert.assertEquals(result.get("currency"), "DKK");

	}
}
