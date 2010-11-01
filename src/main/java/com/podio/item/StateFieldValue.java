package com.podio.item;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StateFieldValue extends FieldValue {

	private String value;

	public StateFieldValue() {
		super();
	}

	public StateFieldValue(String value) {
		super();
		this.value = value;
	}

	@XmlElement(name = "value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
