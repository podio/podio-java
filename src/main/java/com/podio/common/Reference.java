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

	@Override
	public String toString() {
		return type + ":" + id;
	}

	public String toURLFragment() {
		return toURLFragment(true);
	}

	public String toURLFragment(boolean endDash) {
		if (endDash) {
			return type + "/" + id + "/";
		} else {
			return type + "/" + id;
		}
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

	public static Reference parse(String value) {
		String[] split = value.split(":");
		ReferenceType type = ReferenceType.getByName(split[0]);
		int id = Integer.parseInt(split[1]);

		return new Reference(type, id);
	}
}
