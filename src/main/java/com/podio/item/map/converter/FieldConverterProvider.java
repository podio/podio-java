package com.podio.item.map.converter;

import java.lang.reflect.AnnotatedElement;

import com.podio.app.ApplicationField;
import com.podio.app.ApplicationFieldType;

public interface FieldConverterProvider {

	boolean isSupported(ApplicationFieldType fieldType);

	FieldConverter getConverter(ApplicationField field, AnnotatedElement element);
}
