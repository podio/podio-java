package com.podio.file;

import org.codehaus.jackson.annotate.JsonProperty;

public class FileUploadResponse {

	private String jsonRpc;

	private FileUploadResult result;

	private FileError error;

	private String id;

	@Override
	public String toString() {
		return "FileUploadResponse [jsonRpc=" + jsonRpc + ", result=" + result
				+ ", error=" + error + ", id=" + id + "]";
	}

	@JsonProperty("jsonrpc")
	public String getJsonRpc() {
		return jsonRpc;
	}

	@JsonProperty("jsonrpc")
	public void setJsonRpc(String jsonRpc) {
		this.jsonRpc = jsonRpc;
	}

	public FileError getError() {
		return error;
	}

	public void setError(FileError error) {
		this.error = error;
	}

	public FileUploadResult getResult() {
		return result;
	}

	public void setResult(FileUploadResult result) {
		this.result = result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
