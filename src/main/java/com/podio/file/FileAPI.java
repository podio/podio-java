package com.podio.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.joda.time.LocalDate;

import com.podio.ResourceFactory;
import com.podio.common.Reference;
import com.podio.serialize.DateTimeUtil;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

public class FileAPI {

	private final ResourceFactory resourceFactory;

	public FileAPI(ResourceFactory resourceFactory) {
		this.resourceFactory = resourceFactory;
	}

	/**
	 * Uploads the file to the API
	 */
	public int uploadFile(String name, java.io.File file) throws IOException {
		return uploadFile(name, file, null);
	}

	/**
	 * Downloads the file and saves it to given file
	 * 
	 * @param fileId
	 *            The id of the file to download
	 * @param target
	 *            The target file to save the contents to
	 * @throws IOException
	 *             If there was an error reading or writing the file
	 */
	public void downloadFile(int fileId, java.io.File target, FileSize size)
			throws IOException {
		WebResource builder = resourceFactory.getDownloadResource("/" + fileId);
		if (size != null) {
			builder = builder.path("/" + size.name().toLowerCase());
		}
		byte[] data = builder.get(byte[].class);
		FileUtils.writeByteArrayToFile(target, data);
	}

	/**
	 * Uploads the file to the API
	 */
	public int uploadFile(String name, java.io.File file, Reference reference)
			throws IOException {
		FormDataMultiPart multiPart = new FormDataMultiPart();
		multiPart.bodyPart(new FileDataBodyPart("file", file));
		multiPart.field("name", name);

		Builder resource = resourceFactory.getUploadResource("upload.php")
				.entity(multiPart, MediaType.MULTIPART_FORM_DATA_TYPE);
		if (reference != null) {
			resource = resource.header("RefType",
					reference.getType().toString()).header("RefID",
					reference.getId());
		}
		FileUploadResponse response = resource.post(FileUploadResponse.class);
		if (response.getResult() != null) {
			return response.getResult().getFileId();
		} else {
			throw new IOException(response.getError().getMessage());
		}
	}

	public Integer uploadImage(URL url) throws IOException {
		return uploadImage(url, null, null);
	}

	public Integer uploadImage(URL url, Reference reference) throws IOException {
		return uploadImage(url, null, reference);
	}

	public Integer uploadImage(URL url, String name) throws IOException {
		return uploadImage(url, name, null);
	}

	public int uploadImage(URL url, String name, Reference reference)
			throws IOException {
		java.io.File file = readURL(url);
		try {
			String path = url.getPath();
			int lastSlashIdx = path.lastIndexOf('/');
			if (name == null) {
				name = path.substring(lastSlashIdx + 1);
			}

			return uploadFile(name, file, reference);
		} finally {
			file.delete();
		}
	}

	private static java.io.File readURL(URL url) throws IOException {
		InputStream is = url.openStream();
		try {
			java.io.File file = java.io.File.createTempFile(
					Integer.toString(url.hashCode()), null);
			file.deleteOnExit();
			FileOutputStream os = FileUtils.openOutputStream(file);
			try {
				IOUtils.copy(is, os);
			} finally {
				os.close();
			}

			return file;
		} finally {
			is.close();
		}
	}

	/**
	 * Returns the file with the given id
	 */
	public File getFile(int fileId) {
		return resourceFactory.getApiResource("/file/" + fileId)
				.get(File.class);
	}

	/**
	 * Used to update the description of the file.
	 */
	public void updateFile(int fileId, FileUpdate update) {
		resourceFactory.getApiResource("/file/" + fileId)
				.entity(update, MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Deletes the file with the given id.
	 */
	public void deleteFile(int fileId) {
		resourceFactory.getApiResource("/file/" + fileId).delete();
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
		WebResource resource = resourceFactory.getApiResource("/file/app/"
				+ appId + "/latest/");
		if (limit != null) {
			resource = resource.queryParam("limit", limit.toString());
		}
		if (latest != null) {
			resource = resource.queryParam("latest",
					DateTimeUtil.formatDate(latest));
		}

		return resource.get(new GenericType<List<File>>() {
		});
	}

	/**
	 * Returns all the files related to the items in the application. This
	 * includes files both on the item itself and in comments on the item.
	 * 
	 * @param limit
	 *            The maximum number of files to be returned. Defaults to 50 and
	 *            cannot be higher than 100.
	 * @param offset
	 *            The offset to use when returning files to be used for
	 *            pagination. Defaults to 0 (no offset).
	 */
	public List<File> getOnApp(int appId, Integer limit, Integer offset) {
		WebResource resource = resourceFactory.getApiResource("/file/app/"
				+ appId + "/");
		if (limit != null) {
			resource = resource.queryParam("limit", limit.toString());
		}
		if (offset != null) {
			resource = resource.queryParam("offset", offset.toString());
		}

		return resource.get(new GenericType<List<File>>() {
		});
	}

	/**
	 * Returns the latest files on the space order descending by the date the
	 * file was uploaded.
	 * 
	 * @param limit
	 *            The limit of how many files should be returned. Defaults to 10
	 *            and cannot be any higher than 50.
	 * @param latest
	 *            The latest date to return files from. Defaults to no limit.
	 */
	public List<File> getLatestOnSpace(int spaceId, Integer limit,
			LocalDate latest) {
		WebResource resource = resourceFactory.getApiResource("/file/space/"
				+ spaceId + "/latest/");
		if (limit != null) {
			resource = resource.queryParam("limit", limit.toString());
		}
		if (latest != null) {
			resource = resource.queryParam("latest",
					DateTimeUtil.formatDate(latest));
		}

		return resource.get(new GenericType<List<File>>() {
		});
	}

	/**
	 * Returns all the files on the space order by the file name.
	 * 
	 * @param limit
	 *            The maximum number of files to be returned. Defaults to 50 and
	 *            cannot be higher than 100.
	 * @param offset
	 *            The offset to use when returning files to be used for
	 *            pagination. Defaults to 0 (no offset).
	 */
	public List<File> getOnSpace(int spaceId, Integer limit, Integer offset) {
		WebResource resource = resourceFactory.getApiResource("/file/space/"
				+ spaceId + "/");
		if (limit != null) {
			resource = resource.queryParam("limit", limit.toString());
		}
		if (offset != null) {
			resource = resource.queryParam("offset", offset.toString());
		}

		return resource.get(new GenericType<List<File>>() {
		});
	}
}
