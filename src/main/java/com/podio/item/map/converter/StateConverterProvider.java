package com.podio.item.map.converter;

import java.lang.reflect.AnnotatedElement;

import com.podio.app.ApplicationField;
import com.podio.app.ApplicationFieldType;

public class StateConverterProvider implements FieldConverterProvider {

	@Override
	public boolean isSupported(ApplicationFieldType fieldType) {
		return fieldType == ApplicationFieldType.STATE;
	}

	@Override
	public FieldConverter getConverter(ApplicationField field,
			AnnotatedElement element) {
		return new StateConverter(field.getConfiguration().getSettings()
				.getAllowedValues());
	}
}
