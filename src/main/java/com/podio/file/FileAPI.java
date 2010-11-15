package com.podio.file;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

public class FileAPI {

	private final BaseAPI baseAPI;

	public FileAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	public int uploadFile(String name, java.io.File file) throws IOException {
		FormDataMultiPart multiPart = new FormDataMultiPart();
		multiPart.bodyPart(new FileDataBodyPart("file", file));
		multiPart.field("name", name);

		FileUploadResponse response = baseAPI.getUploadResource("upload.php")
				.entity(multiPart, MediaType.MULTIPART_FORM_DATA_TYPE)
				.post(FileUploadResponse.class);
		if (response.getResult() != null) {
			return response.getResult().getFileId();
		} else {
			throw new IOException(response.getError().getMessage());
		}
	}
}
