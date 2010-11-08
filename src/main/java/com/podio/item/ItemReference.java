package com.podio.item;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.app.ApplicationMicro;

public class ItemReference {

	private ApplicationMicro application;

	private List<ItemMicro> items;

	@JsonProperty("app")
	public ApplicationMicro getApplication() {
		return application;
	}

	@JsonProperty("app")
	public void setApplication(ApplicationMicro application) {
		this.application = application;
	}

	public List<ItemMicro> getItems() {
		return items;
	}

	public void setItems(List<ItemMicro> items) {
		this.items = items;
	}

}
