package com.podio.item.map.converter;

import java.beans.PropertyDescriptor;

import org.apache.commons.beanutils.ConvertUtils;

public class ExternalIdConverter {

	private final PropertyDescriptor descriptor;

	public ExternalIdConverter(PropertyDescriptor descriptor) {
		super();
		this.descriptor = descriptor;
	}

	public String fromModel(Object model) {
		Object value;
		try {
			value = descriptor.getReadMethod().invoke(model);
		} catch (Exception e) {
			throw new RuntimeException("Unable to get external id");
		}
		if (value == null) {
			return null;
		}

		return (String) ConvertUtils.convert(value, String.class);
	}

	public void toModel(String externalId, Object model) {
		Object value = ConvertUtils.convert(externalId,
				descriptor.getPropertyType());

		try {
			descriptor.getWriteMethod().invoke(model, value);
		} catch (Exception e) {
			throw new RuntimeException("Unable to set external id", e);
		}
	}
}
