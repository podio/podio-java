package com.podio.app;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApplicationFieldSettings {

	private List<String> allowedValues;

	private List<Integer> referenceableTypes;

	private List<String> allowedCurrencies;

	public ApplicationFieldSettings() {
		super();
	}

	public ApplicationFieldSettings(List<String> allowedValues,
			List<Integer> referenceableTypes, List<String> allowedCurrencies) {
		super();
		this.allowedValues = allowedValues;
		this.referenceableTypes = referenceableTypes;
		this.allowedCurrencies = allowedCurrencies;
	}

	@XmlElement(name = "allowed_values")
	public List<String> getAllowedValues() {
		return allowedValues;
	}

	public void setAllowedValues(List<String> allowedValues) {
		this.allowedValues = allowedValues;
	}

	@XmlElement(name = "referenceable_types")
	public List<Integer> getReferenceableTypes() {
		return referenceableTypes;
	}

	public void setReferenceableTypes(List<Integer> referenceableTypes) {
		this.referenceableTypes = referenceableTypes;
	}

	@XmlElement(name = "allowed_currencies")
	public List<String> getAllowedCurrencies() {
		return allowedCurrencies;
	}

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
		return new ApplicationFieldSettings(allowedValues, null, null);
	}

	public static ApplicationFieldSettings getApp(
			List<Integer> referenceableTypes) {
		return new ApplicationFieldSettings(null, referenceableTypes, null);
	}

	public static ApplicationFieldSettings getMoney(
			List<String> allowedCurrencies) {
		return new ApplicationFieldSettings(null, null, allowedCurrencies);
	}
}
