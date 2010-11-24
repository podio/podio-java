package com.podio.app;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplicationFieldSettings {

	private TextFieldSize size;

	private List<String> allowedValues;

	private List<Integer> referenceableTypes;

	private List<String> allowedCurrencies;

	public ApplicationFieldSettings() {
		super();
	}

	public ApplicationFieldSettings(TextFieldSize size,
			List<String> allowedValues, List<Integer> referenceableTypes,
			List<String> allowedCurrencies) {
		super();
		this.size = size;
		this.allowedValues = allowedValues;
		this.referenceableTypes = referenceableTypes;
		this.allowedCurrencies = allowedCurrencies;
	}

	@JsonProperty("size")
	public TextFieldSize getSize() {
		return size;
	}

	@JsonProperty("size")
	public void setSize(TextFieldSize size) {
		this.size = size;
	}

	@JsonProperty("allowed_values")
	public List<String> getAllowedValues() {
		return allowedValues;
	}

	@JsonProperty("allowed_values")
	public void setAllowedValues(List<String> allowedValues) {
		this.allowedValues = allowedValues;
	}

	@JsonProperty("referenceable_types")
	public List<Integer> getReferenceableTypes() {
		return referenceableTypes;
	}

	@JsonProperty("referenceable_types")
	public void setReferenceableTypes(List<Integer> referenceableTypes) {
		this.referenceableTypes = referenceableTypes;
	}

	@JsonProperty("allowed_currencies")
	public List<String> getAllowedCurrencies() {
		return allowedCurrencies;
	}

	@JsonProperty("allowed_currencies")
	public void setAllowedCurrencies(List<String> allowedCurrencies) {
		this.allowedCurrencies = allowedCurrencies;
	}

	@Override
	public String toString() {
		return "ApplicationFieldSettings [allowedValues=" + allowedValues
				+ ", referenceableTypes=" + referenceableTypes
				+ ", allowedCurrencies=" + allowedCurrencies + "]";
	}

	public static ApplicationFieldSettings getState(List<String> allowedValues) {
		return new ApplicationFieldSettings(null, allowedValues, null, null);
	}

	public static ApplicationFieldSettings getApp(
			List<Integer> referenceableTypes) {
		return new ApplicationFieldSettings(null, null, referenceableTypes,
				null);
	}

	public static ApplicationFieldSettings getText(TextFieldSize size) {
		return new ApplicationFieldSettings(size, null, null, null);
	}

	public static ApplicationFieldSettings getMoney(
			List<String> allowedCurrencies) {
		return new ApplicationFieldSettings(null, null, null, allowedCurrencies);
	}
}
