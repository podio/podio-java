package com.podio;

import java.util.Map;

import com.sun.jersey.api.client.ClientResponse.Status;

public class APIApplicationException extends RuntimeException {

	private static final long serialVersionUID = -4533177892434958205L;

	private final Status status;

	private final String error;

	private final String description;

	private final Map<String, Object> parameters;

	public APIApplicationException(Status status, String error,
			String description, Map<String, Object> parameters) {
		super();
		this.status = status;
		this.error = error;
		this.description = description;
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		return "APIException [status=" + status + ", error=" + error
				+ ", description=" + description + ", parameters=" + parameters
				+ "]";
	}

	public Status getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getDescription() {
		return description;
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}
}
