package com.podio.app;

import java.io.Serializable;

public class CategoryOption implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	
	private CategoryOptionStatus status;
	
	private String text;
	
	private String color;

	public CategoryOption() {
		super();
	}

	public CategoryOption(int id, CategoryOptionStatus status, String text,
			String color) {
		super();
		this.id = id;
		this.status = status;
		this.text = text;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CategoryOptionStatus getStatus() {
		return status;
	}

	public void setStatus(CategoryOptionStatus status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
