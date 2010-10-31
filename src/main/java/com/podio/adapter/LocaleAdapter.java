package com.podio.adapter;

import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocaleAdapter extends XmlAdapter<String, Locale> {

	@Override
	public Locale unmarshal(String value) throws Exception {
		return new Locale(value);
	}

	@Override
	public String marshal(Locale locale) throws Exception {
		return locale.getLanguage();
	}
}
