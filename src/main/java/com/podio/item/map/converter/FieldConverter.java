package com.podio.item.map.converter;

import java.util.Map;

public interface FieldConverter {

	Map<String, Object> fromModel(Object value);

	Object toModel(Map<String, Object> map, Class modelClass);
}
