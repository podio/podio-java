package com.podio.rating;

import java.util.Map;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.namespace.QName;

public class ObjectRatings {

	private Map<QName, TypeRating> types;

	public TypeRating getRating(RatingType type) {
		return types.get(new QName(type.name().toLowerCase()));
	}

	public Map<QName, TypeRating> getTypes() {
		return types;
	}

	public void setTypes(Map<QName, TypeRating> types) {
		this.types = types;
	}
}
