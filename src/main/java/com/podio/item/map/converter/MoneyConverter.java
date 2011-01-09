package com.podio.item.map.converter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class MoneyConverter implements FieldConverter {

	private final CurrencyUnit defaultCurrency;

	public MoneyConverter(CurrencyUnit defaultCurrency) {
		super();
		this.defaultCurrency = defaultCurrency;
	}

	@Override
	public Map<String, ?> fromModel(Object value) {
		Map<String, Object> map = new HashMap<String, Object>();

		Class<? extends Object> javaClass = value.getClass();
		if (javaClass == Money.class) {
			Money moneyValue = (Money) value;

			map.put("value", moneyValue.getAmount().toPlainString());
			map.put("currency", moneyValue.getCurrencyUnit().getCurrencyCode());
		} else {
			map.put("value", ((BigDecimal) ConvertUtils.convert(value,
					BigDecimal.class)).toPlainString());
			map.put("currency", defaultCurrency.getCurrencyCode());
		}

		return map;
	}

	@Override
	public Object toModel(Map<String, ?> map, Class modelClass) {
		if (modelClass == Money.class) {
			BigDecimal amount = new BigDecimal((String) map.get("value"));
			CurrencyUnit currency = CurrencyUnit.of((String) map
					.get("currency"));
			BigDecimal roundedAmount = amount.setScale(
					currency.getDecimalPlaces(), RoundingMode.HALF_EVEN);

			return Money.of(currency, roundedAmount);
		} else {
			return ConvertUtils.convert(map.get("value"), modelClass);
		}
	}
}
