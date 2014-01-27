package com.podio.app;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplicationMicro implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The id of the app
	 */
	private int id;

	/**
	 * The name of the app
	 */
	private String name;

	/**
	 * The name of an item in the app
	 */
	private String itemName;

	/**
	 * The icon of the app
	 */
	private String icon;

	public ApplicationMicro() {
		super();
	}

	public ApplicationMicro(int id, String name, String itemName, String icon) {
		super();
		this.id = id;
		this.name = name;
		this.itemName = itemName;
		this.icon = icon;
	}

	@JsonProperty("app_id")
	public int getId() {
		return id;
	}

	@JsonProperty("app_id")
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("item_name")
	public String getItemName() {
		return itemName;
	}

	@JsonProperty("item_name")
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
