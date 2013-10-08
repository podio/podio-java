package com.podio.common;

import java.io.Serializable;
import java.net.URL;

public class AuthorizationInterface implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String name;

	private URL url;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}
}
