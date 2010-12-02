package com.podio.rating;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnySetter;

public class RatingValuesMap {

	private final Map<RatingType, TypeRating> values = new HashMap<RatingType, TypeRating>();

	public TypeRating get(RatingType type) {
		return values.get(type);
	}

	@JsonAnySetter
	public void set(String type, TypeRating value) {
		values.put(RatingType.getByName(type), value);
	}
}
