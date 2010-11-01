package com.podio.app;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApplicationMicro {

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

	@XmlElement(name = "app_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "item_name")
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@XmlElement(name = "icon")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
