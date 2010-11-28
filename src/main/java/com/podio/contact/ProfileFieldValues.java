package com.podio.contact;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonValue;

public final class ProfileFieldValues {

	private Map<ProfileField<?, ?>, Object> values = new HashMap<ProfileField<?, ?>, Object>();

	@JsonValue
	public Map<ProfileField<?, ?>, Object> getValues() {
		return values;
	}

	public void setValues(Map<ProfileField<?, ?>, Object> values) {
		this.values = values;
	}

	public <F> void setValue(ProfileField<F, ?> field, F value) {
		if (field.isSingle()) {
			values.put(field, value);
		} else {
			values.put(field, Collections.singletonList(value));
		}
	}

	public <F> F getValue(ProfileField<F, ?> field) {
		if (field.isSingle()) {
			return (F) values.get(field);
		} else {
			List<Object> list = (List<Object>) values.get(field);
			if (list == null || list.isEmpty()) {
				return null;
			}

			return (F) list.get(0);
		}
	}

	public <F> void setValues(ProfileField<F, ?> field, List<F> values) {
		this.values.put(field, values);
	}

	public <F> List<F> getValues(ProfileField<F, ?> field) {
		return (List<F>) values.get(field);
	}
}