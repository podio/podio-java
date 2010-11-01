package com.podio.rating;

import java.util.Map;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

@XmlRootElement
public class ObjectRatings {

	private Map<QName, TypeRating> types;

	public TypeRating getRating(RatingType type) {
		return types.get(new QName(type.name().toLowerCase()));
	}

	@XmlAnyAttribute
	public Map<QName, TypeRating> getTypes() {
		return types;
	}

	public void setTypes(Map<QName, TypeRating> types) {
		this.types = types;
	}
}
