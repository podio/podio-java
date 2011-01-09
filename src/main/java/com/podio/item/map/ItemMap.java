package com.podio.item.map;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.podio.app.Application;
import com.podio.app.ApplicationField;
import com.podio.item.FieldValuesUpdate;
import com.podio.item.FieldValuesView;
import com.podio.item.Item;
import com.podio.item.ItemBadge;
import com.podio.item.ItemCreate;
import com.podio.item.ItemUpdate;
import com.podio.item.map.converter.ExternalIdConverter;

public class ItemMap<T> {

	private final Class<T> modelClass;

	private final List<FieldMap> fieldMaps;

	private final ExternalIdConverter externalIdConverter;

	public ItemMap(Class<T> modelClass, List<FieldMap> fieldMaps,
			ExternalIdConverter externalIdConverter) {
		super();
		this.modelClass = modelClass;
		this.fieldMaps = fieldMaps;
		this.externalIdConverter = externalIdConverter;
	}

	public ItemCreate getCreate(T model) {
		return new ItemCreate(getExternalId(model), getUpdates(model),
				Collections.<Integer> emptyList(),
				Collections.<String> emptyList());
	}

	private String getExternalId(T model) {
		String externalId = null;
		if (externalIdConverter != null) {
			externalId = externalIdConverter.fromModel(model);
		}
		return externalId;
	}

	private void setExternalId(String externalId, T model) {
		if (externalIdConverter != null) {
			externalIdConverter.toModel(externalId, model);
		}
	}

	private List<FieldValuesUpdate> getUpdates(T model) {
		List<FieldValuesUpdate> updates = new ArrayList<FieldValuesUpdate>();
		for (FieldMap fieldMap : fieldMaps) {
			FieldValuesUpdate update = fieldMap.fromModel(model);

			updates.add(update);
		}

		return updates;
	}

	public ItemUpdate getUpdate(T model) {
		return new ItemUpdate(getExternalId(model), getUpdates(model));
	}

	public T getView(Item item) {
		return getView(item.getExternalId(), item.getFields());
	}

	public T getView(ItemBadge item) {
		return getView(item.getExternalId(), item.getFields());
	}

	private T getView(String externalId, List<FieldValuesView> views) {
		T model;
		try {
			model = modelClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Unable to create new "
					+ modelClass.getName()
					+ ", ensure that a non-arguments public constructor exists");
		}

		setExternalId(externalId, model);

		for (FieldMap fieldMap : fieldMaps) {
			fieldMap.toModel(model, views);
		}

		return model;
	}

	public static <T> ItemMap<T> get(Application application,
			Class<T> modelClass) {
		Map<String, ApplicationField> fields = new HashMap<String, ApplicationField>();
		for (ApplicationField field : application.getFields()) {
			fields.put(field.getExternalId(), field);
		}

		List<FieldMap> fieldMaps = new ArrayList<FieldMap>();
		ExternalIdConverter externalIdConverter = null;

		PropertyDescriptor[] descriptors = PropertyUtils
				.getPropertyDescriptors(modelClass);
		for (PropertyDescriptor descriptor : descriptors) {
			if (descriptor.getReadMethod() == null
					|| descriptor.getWriteMethod() == null) {
				continue;
			}

			Transient tr = descriptor.getReadMethod().getAnnotation(
					Transient.class);
			if (tr != null) {
				continue;
			}

			ExternalId externalId = descriptor.getReadMethod().getAnnotation(
					ExternalId.class);
			if (externalId != null) {
				externalIdConverter = new ExternalIdConverter(descriptor);
				continue;
			}

			fieldMaps.add(FieldMap.get(descriptor, fields));
		}

		return new ItemMap<T>(modelClass, fieldMaps, externalIdConverter);
	}
}
