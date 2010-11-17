package com.podio.file;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.joda.time.LocalDate;

import com.podio.BaseAPI;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

public class FileAPI {

	private final BaseAPI baseAPI;

	public FileAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	/**
	 * Uploads the file to the API
	 */
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

	/**
	 * Returns the file with the given id
	 */
	public File getFile(int fileId) {
		return baseAPI.getApiResource("/file/" + fileId)
				.accept(MediaType.APPLICATION_JSON_TYPE).get(File.class);
	}

	/**
	 * Used to update the description of the file.
	 */
	public void updateFile(int fileId, FileUpdate update) {
		baseAPI.getApiResource("/file/" + fileId)
				.entity(update, MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Deletes the file with the given id.
	 */
	public void deleteFile(int fileId) {
		baseAPI.getApiResource("/file/" + fileId).delete();
	}

	/**
	 * Returns the latest files added to the app sorted descending by the time
	 * the file was uploaded. This includes both files from items directly and
	 * from comments to items.
	 * 
	 * @param limit
	 *            The limit of how many files should be returned. Defaults to 10
	 *            and cannot be any higher than 50.
	 * @param latest
	 *            The latest date to return files from. Defaults to no limit.
	 */
	public List<File> getLatestOnApp(int appId, Integer limit, LocalDate latest) {
		return baseAPI.getApiResource("/file/app/" + appId + "/latest/")
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(new GenericType<List<File>>() {
				});
	}
}
