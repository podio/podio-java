package com.podio.item;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.app.ApplicationMicro;

public class ItemMini {

	/**
	 * The id of the item
	 */
	private int id;

	/**
	 * The title of the item. This is made of up one of the fields below, or by
	 * the item name and id
	 */
	private String title;

	/**
	 * The information on who created the first revision of the item
	 */
	private ItemRevision initialRevision;

	/**
	 * The app where the item belongs
	 */
	private ApplicationMicro application;

	@JsonProperty("item_id")
	public int getId() {
		return id;
	}

	@JsonProperty("item_id")
	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("app")
	public ApplicationMicro getApplication() {
		return application;
	}

	@JsonProperty("app")
	public void setApplication(ApplicationMicro application) {
		this.application = application;
	}

	@JsonProperty("initial_revision")
	public ItemRevision getInitialRevision() {
		return initialRevision;
	}

	@JsonProperty("initial_revision")
	public void setInitialRevision(ItemRevision initialRevision) {
		this.initialRevision = initialRevision;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
