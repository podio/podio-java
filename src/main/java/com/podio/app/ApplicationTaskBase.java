package com.podio.app;

import java.io.Serializable;

public class ApplicationTaskBase implements Serializable {

	private static final long serialVersionUID = 1L;

	private String text;
	
	public ApplicationTaskBase() {
		super();
	}

	public ApplicationTaskBase(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
