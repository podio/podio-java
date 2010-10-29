package com.podio.app;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApplicationFieldSettings {

	private List<String> allowedValues;

	private List<Integer> referenceableTypes;

	private List<String> allowedCurrencies;

	@Override
	public String toString() {
		return "ApplicationFieldSettings [allowedValues=" + allowedValues
				+ ", referenceableTypes=" + referenceableTypes
				+ ", allowedCurrencies=" + allowedCurrencies + "]";
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
}
