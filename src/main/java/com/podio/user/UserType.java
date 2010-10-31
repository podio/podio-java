package com.podio.user;

import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum UserType {

	@XmlEnumValue("light")
	LIGHT,
	@XmlEnumValue("regular")
	REGULAR,
	@XmlEnumValue("admin")
	ADMIN;
}
