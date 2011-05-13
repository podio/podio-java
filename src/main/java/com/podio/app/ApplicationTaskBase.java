package com.podio.app;

public class ApplicationTaskBase {

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
