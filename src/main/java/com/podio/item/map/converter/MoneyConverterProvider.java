package com.podio.item.map.converter;

import java.lang.reflect.AnnotatedElement;

import org.joda.money.CurrencyUnit;

import com.podio.app.ApplicationField;
import com.podio.app.ApplicationFieldType;
import com.podio.item.map.MoneyField;

public class MoneyConverterProvider implements FieldConverterProvider {

	@Override
	public boolean isSupported(ApplicationFieldType fieldType) {
		return fieldType == ApplicationFieldType.MONEY;
	}

	@Override
	public FieldConverter getConverter(ApplicationField field,
			AnnotatedElement element) {
		MoneyField moneyField = element.getAnnotation(MoneyField.class);

		CurrencyUnit defaultCurrency;
		if (moneyField != null) {
			defaultCurrency = CurrencyUnit.of(moneyField.currency());
		} else {
			defaultCurrency = CurrencyUnit.of(field.getConfiguration()
					.getSettings().getAllowedCurrencies().get(0));
		}

		return new MoneyConverter(defaultCurrency);
	}
}
