package com.podio.adapter;

import java.util.TimeZone;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TimeZoneAdapter extends XmlAdapter<String, TimeZone> {

	@Override
	public String marshal(TimeZone value) throws Exception {
		return value.getID();
	}

	@Override
	public TimeZone unmarshal(String value) throws Exception {
		return TimeZone.getTimeZone(value);
	}

}
