package com.podio.item.map.converter;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;

public class StateConverter implements FieldConverter {

	private final List<String> states;

	public StateConverter(List<String> states) {
		super();
		this.states = states;
	}

	@Override
	public Map<String, ?> fromModel(Object value) {
		if (value.getClass().isEnum()) {
			String stringValue = value.toString();
			stringValue = stringValue.replace(' ', '_');

			for (String state : states) {
				if (state.equalsIgnoreCase(stringValue)) {
					return Collections.singletonMap("value", state);
				}
			}

			throw new RuntimeException("No state with name " + stringValue
					+ " found");
		} else {
			String stringValue = (String) ConvertUtils.convert(value,
					String.class);

			return Collections.singletonMap("value", stringValue);
		}
	}

	@Override
	public Object toModel(Map<String, ?> map, Class modelClass) {
		String state = (String) map.get("value");

		if (modelClass.isEnum()) {
			return Enum.valueOf(modelClass, state.toUpperCase());
		} else {
			return ConvertUtils.convert(state, modelClass);
		}
	}
}
