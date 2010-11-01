package com.podio.rating;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TypeRating {

	private RatingCounts counts;

	private Float average;

	@XmlElement(name = "counts")
	public RatingCounts getCounts() {
		return counts;
	}

	public void setCounts(RatingCounts counts) {
		this.counts = counts;
	}

	@XmlElement(name = "average")
	public Float getAverage() {
		return average;
	}

	public void setAverage(Float average) {
		this.average = average;
	}

}
