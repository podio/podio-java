package com.podio.item.map.converter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.podio.app.ApplicationField;

public class FieldConverterRegistry {

	private static final List<FieldConverterProvider> REGISTRY = new ArrayList<FieldConverterProvider>();

	static {
		REGISTRY.add(new MoneyConverterProvider());
		REGISTRY.add(new CategoryConverterProvider());
		REGISTRY.add(new NumberConverterProvider());
		REGISTRY.add(new TextConverterProvider());
		REGISTRY.add(new ProgressConverterProvider());
	}

	private FieldConverterRegistry() {
	}

	public static FieldConverter getConverter(ApplicationField field,
			Method readMethod) {
		for (FieldConverterProvider provider : REGISTRY) {
			if (provider.isSupported(field.getType())) {
				return provider.getConverter(field, readMethod);
			}
		}

		throw new RuntimeException("No converter found for field of type "
				+ field.getType());
	}
}
