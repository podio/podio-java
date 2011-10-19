package com.podio.hook;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.common.CreatedBase;

public class Hook extends CreatedBase {

	private int id;

	private HookStatus status;

	private HookType type;

	private String url;

	public int getId() {
		return id;
	}

	@JsonProperty("hook_id")
	public void setId(int id) {
		this.id = id;
	}

	public HookStatus getStatus() {
		return status;
	}

	public void setStatus(HookStatus status) {
		this.status = status;
	}

	public HookType getType() {
		return type;
	}

	public void setType(HookType type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
