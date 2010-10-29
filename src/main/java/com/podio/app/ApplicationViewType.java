package com.podio.app;

import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum ApplicationViewType {

	@XmlEnumValue("badge")
	BADGE(),
	@XmlEnumValue("table")
	TABLE(),
	@XmlEnumValue("list")
	LIST(),
	@XmlEnumValue("node")
	NODE(),
	@XmlEnumValue("calendar")
	CALENDAR(),
	@XmlEnumValue("gallery")
	GALLERY();
}
