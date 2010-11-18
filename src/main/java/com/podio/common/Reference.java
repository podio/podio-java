package com.podio.common;

public class Reference {

	private ReferenceType type;

	private int id;

	public Reference() {
		super();
	}

	public Reference(ReferenceType type, int id) {
		super();
		this.type = type;
		this.id = id;
	}

	public ReferenceType getType() {
		return type;
	}

	public void setType(ReferenceType type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
