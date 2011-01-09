package com.podio.item.map.converter;

import java.lang.reflect.AnnotatedElement;

import com.podio.app.ApplicationField;
import com.podio.app.ApplicationFieldType;

public class ProgressConverterProvider implements FieldConverterProvider {

	@Override
	public boolean isSupported(ApplicationFieldType fieldType) {
		return fieldType == ApplicationFieldType.PROGRESS;
	}

	@Override
	public FieldConverter getConverter(ApplicationField field,
			AnnotatedElement element) {
		return new ProgressConverter();
	}

}
