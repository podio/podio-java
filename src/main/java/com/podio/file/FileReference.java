package com.podio.file;

import com.podio.common.Reference;
import com.podio.common.ReferenceType;

public class FileReference extends Reference {

	/**
	 * The title of the reference
	 */
	private String title;

	public FileReference() {
		super();
	}

	public FileReference(ReferenceType type, int id, String title) {
		super(type, id);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
