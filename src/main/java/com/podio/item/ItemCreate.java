package com.podio.item;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ItemCreate extends ItemUpdate {

	/**
	 * Temporary files that have been uploaded and should be attached to this
	 * item
	 */
	private List<Integer> fileIds;

	/**
	 * The tags to put on the item
	 */
	private List<String> tags;

	public ItemCreate() {
		super();
	}

	public ItemCreate(String externalId, List<FieldValuesUpdate> fields,
			List<Integer> fileIds, List<String> tags) {
		super(externalId, fields);
		this.fileIds = fileIds;
		this.tags = tags;
	}

	@JsonProperty("file_ids")
	public List<Integer> getFileIds() {
		return fileIds;
	}

	@JsonProperty("file_ids")
	public void setFileIds(List<Integer> fileIds) {
		this.fileIds = fileIds;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
