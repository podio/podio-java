package com.podio.rating;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TypeRating implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Map<Integer, ValueRatings> counts = new HashMap<Integer, ValueRatings>();

	private Float average;

	@Override
	public String toString() {
		return "TypeRating [counts=" + counts + ", average=" + average + "]";
	}

	public ValueRatings getCounts(int value) {
		return counts.get(value);
	}

	public Map<Integer, ValueRatings> getCounts() {
		return counts;
	}

	public void setCounts(Map<Integer, ValueRatings> counts) {
		this.counts = counts;
	}

	public Float getAverage() {
		return average;
	}

	public void setAverage(Float average) {
		this.average = average;
	}

}
