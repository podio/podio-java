package com.podio.rating;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnySetter;

public class RatingValuesMap implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Map<RatingType, TypeRating> values = new HashMap<RatingType, TypeRating>();

	public TypeRating get(RatingType type) {
		return values.get(type);
	}

	@JsonAnySetter
	public void set(String type, TypeRating value) {
		values.put(RatingType.getByName(type), value);
	}
}
