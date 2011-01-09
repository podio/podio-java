package com.podio.item.map.converter;

import java.util.Collections;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;

public class TextConverter implements FieldConverter {

	@Override
	public Map<String, ?> fromModel(Object value) {
		String stringValue = (String) ConvertUtils.convert(value, String.class);

		return Collections.<String, Object> singletonMap("value", stringValue);
	}

	@Override
	public Object toModel(Map<String, ?> map, Class modelClass) {
		return ConvertUtils.convert(map.get("value"), modelClass);
	}

}
