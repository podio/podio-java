package com.podio.item.map.converter;

import java.lang.reflect.AnnotatedElement;

import com.podio.app.ApplicationField;
import com.podio.app.ApplicationFieldType;

public class NumberConverterProvider implements FieldConverterProvider {

	@Override
	public boolean isSupported(ApplicationFieldType fieldType) {
		return fieldType == ApplicationFieldType.NUMBER;
	}

	@Override
	public FieldConverter getConverter(ApplicationField field,
			AnnotatedElement element) {
		return new NumberConverter();
	}

}
