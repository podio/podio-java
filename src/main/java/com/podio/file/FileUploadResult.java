package com.podio.file;

import org.codehaus.jackson.annotate.JsonProperty;

public class FileUploadResult {

	private int fileId;

	@Override
	public String toString() {
		return "FileUploadResult [fileId=" + fileId + "]";
	}

	@JsonProperty("file_id")
	public int getFileId() {
		return fileId;
	}

	@JsonProperty("file_id")
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
}
