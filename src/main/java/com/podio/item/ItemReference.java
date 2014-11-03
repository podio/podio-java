package com.podio.item;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.app.Application;

public class ItemReference {

	private Application application;

	private List<ItemMicro> items;

	@JsonProperty("app")
	public Application getApplication() {
		return application;
	}

	@JsonProperty("app")
	public void setApplication(Application application) {
		this.application = application;
	}

	public List<ItemMicro> getItems() {
		return items;
	}

	public void setItems(List<ItemMicro> items) {
		this.items = items;
	}

}
