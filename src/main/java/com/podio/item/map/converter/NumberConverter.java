package com.podio.item.map.converter;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;

public class NumberConverter implements FieldConverter {

	@Override
	public Map<String, ?> fromModel(Object value) {
		BigDecimal bdValue = (BigDecimal) ConvertUtils.convert(value,
				BigDecimal.class);

		return Collections.singletonMap("value", bdValue.toPlainString());
	}

	@Override
	public Object toModel(Map<String, ?> map, Class modelClass) {
		BigDecimal bdValue = new BigDecimal((String) map.get("value"));

		return ConvertUtils.convert(bdValue, modelClass);
	}
}
