package com.podio.item.map.converter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;

import com.podio.app.CategoryOption;

public class CategoryConverter implements FieldConverter {

	private final List<CategoryOption> options;

	public CategoryConverter(List<CategoryOption> options) {
		super();
		this.options = options;
	}

	@Override
	public Map<String, ?> fromModel(Object value) {
		String stringValue;
		if (value.getClass().isEnum()) {
			stringValue = value.toString();
			stringValue = stringValue.replace(' ', '_');
		} else {
			stringValue = (String) ConvertUtils.convert(value,
					String.class);
		}
			
		CategoryOption option = getOptionByText(stringValue);
		if (option != null) {
			return Collections.singletonMap("value", option.getId());
		}

		throw new RuntimeException("No state with name " + stringValue
				+ " found");
	}
	
	private CategoryOption getOptionByText(String text) {
		for (CategoryOption option : options) {
			if (option.getText().equalsIgnoreCase(text)) {
				return option;
			}
		}
		
		return null;
	}

	@Override
	public Object toModel(Map<String, ?> map, Class modelClass) {
		Map<String, Object> option = (Map<String, Object>) map.get("value");
		
		String stringValue = (String) option.get("text");

		if (modelClass.isEnum()) {
			return Enum.valueOf(modelClass, stringValue.toUpperCase());
		} else {
			return ConvertUtils.convert(stringValue, modelClass);
		}
	}
}
