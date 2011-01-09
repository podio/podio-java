package com.podio.item.map;

import java.math.BigDecimal;
import java.util.List;

public class BugMap2 {

	private long externalId;

	private List<String> statuses;

	private BigDecimal alottaCash;

	private double importance;

	private Short howFarAreWe;

	public BugMap2() {
		super();
	}

	public BugMap2(long externalId, List<String> statuses,
			BigDecimal alottaCash, double importance, Short howFarAreWe) {
		super();
		this.externalId = externalId;
		this.statuses = statuses;
		this.alottaCash = alottaCash;
		this.importance = importance;
		this.howFarAreWe = howFarAreWe;
	}

	@ExternalId
	public long getExternalId() {
		return externalId;
	}

	public void setExternalId(long externalId) {
		this.externalId = externalId;
	}

	@Field("is-hired")
	public List<String> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<String> statuses) {
		this.statuses = statuses;
	}

	public BigDecimal getAlottaCash() {
		return alottaCash;
	}

	public void setAlottaCash(BigDecimal amount) {
		this.alottaCash = amount;
	}

	public double getImportance() {
		return importance;
	}

	public void setImportance(double importance) {
		this.importance = importance;
	}

	public Short getHowFarAreWe() {
		return howFarAreWe;
	}

	public void setHowFarAreWe(Short howFarAreWe) {
		this.howFarAreWe = howFarAreWe;
	}
}