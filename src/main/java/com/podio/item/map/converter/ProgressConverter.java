package com.podio.item.map.converter;

import java.util.Collections;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;

public class ProgressConverter implements FieldConverter {

	@Override
	public Map<String, ?> fromModel(Object value) {
		Integer integerValue = (Integer) ConvertUtils.convert(value,
				Integer.class);

		return Collections.singletonMap("value", integerValue);
	}

	@Override
	public Object toModel(Map<String, ?> map, Class modelClass) {
		Integer value = (Integer) map.get("value");

		return ConvertUtils.convert(value, modelClass);
	}

}
