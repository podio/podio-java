package com.podio.item.map.converter;

import java.lang.reflect.Method;

import com.podio.app.ApplicationField;
import com.podio.app.ApplicationFieldType;

public interface FieldConverterProvider {

	boolean isSupported(ApplicationFieldType fieldType);

	FieldConverter getConverter(ApplicationField field, Method readMethod);
}
