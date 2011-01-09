package com.podio.item.map;

import java.util.Collection;

public class BugMap3 {

	private String externalId;

	private Collection<String> statuses;

	private double amount;

	private float importance;

	public BugMap3() {
		super();
	}

	public BugMap3(String externalId, Collection<String> statuses,
			double amount, float importance) {
		super();
		this.externalId = externalId;
		this.statuses = statuses;
		this.amount = amount;
		this.importance = importance;
	}

	@ExternalId
	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	@Field("is-hired")
	public Collection<String> getStatuses() {
		return statuses;
	}

	public void setStatuses(Collection<String> statuses) {
		this.statuses = statuses;
	}

	@MoneyField(currency = "EUR")
	@Field("alotta-cash")
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public float getImportance() {
		return importance;
	}

	public void setImportance(float importance) {
		this.importance = importance;
	}
}