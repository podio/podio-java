package com.podio.app;

import java.util.List;

public class ApplicationUpdate extends ApplicationBase {

	/**
	 * True if all space members should be resubscribed to this app, false
	 * otherwise
	 */
	private boolean resubscribe;

	private List<ApplicationFieldUpdate> fields;

	public ApplicationUpdate() {
		super();
	}

	public ApplicationUpdate(boolean resubscribe,
			ApplicationConfiguration configuration,
			List<ApplicationFieldUpdate> fields) {
		super(configuration);
		this.resubscribe = resubscribe;
		this.fields = fields;
	}

	public boolean isResubscribe() {
		return resubscribe;
	}

	public void setResubscribe(boolean resubscribe) {
		this.resubscribe = resubscribe;
	}

	public List<ApplicationFieldUpdate> getFields() {
		return fields;
	}

	public void setFields(List<ApplicationFieldUpdate> fields) {
		this.fields = fields;
	}
}
