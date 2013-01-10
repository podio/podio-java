package com.podio.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

public class FileAPI extends BaseAPI {

	public FileAPI(ResourceFactory resourceFactory) {
		super(resourceFactory);
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
		WebResource builder = getResourceFactory()
				.getFileResource("/" + fileId);
		if (size != null) {
			builder = builder.path("/" + size.name().toLowerCase());
		}
		byte[] data = builder.get(byte[].class);
		FileUtils.writeByteArrayToFile(target, data);
	}

	/**
	 * Uploads the file to the API
	 */
	public int uploadFile(String name, java.io.File file) {
		FileDataBodyPart filePart = new FileDataBodyPart("source", file);
		// Work around for bug in cherrypy
		FormDataContentDisposition.FormDataContentDispositionBuilder builder = FormDataContentDisposition
				.name(filePart.getName());
		builder.fileName(file.getName());
		builder.size(file.length());
		filePart.setFormDataContentDisposition(builder.build());

		FormDataMultiPart multiPart = new FormDataMultiPart();
		multiPart.bodyPart(filePart);
		multiPart.field("filename", name);

		Builder resource = getResourceFactory().getApiResource("/file/v2/")
				.entity(multiPart,
						new MediaType("multipart", "form-data", Collections
								.singletonMap("boundary", "AaB03x")));
		return resource.post(File.class).getId();
	}

	public Integer uploadImage(URL url) throws IOException {
		return uploadImage(url, null);
	}

	public int uploadImage(URL url, String name) throws IOException {
		java.io.File file = readURL(url);
		try {
			String path = url.getPath();
			int lastSlashIdx = path.lastIndexOf('/');
			if (name == null) {
				name = path.substring(lastSlashIdx + 1);
			}

			return uploadFile(name, file);
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
		return getResourceFactory().getApiResource("/file/" + fileId).get(
				File.class);
	}

	/**
	 * Used to update the description of the file.
	 */
	public void updateFile(int fileId, FileUpdate update) {
		getResourceFactory().getApiResource("/file/" + fileId)
				.entity(update, MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Deletes the file with the given id.
	 */
	public void deleteFile(int fileId) {
		getResourceFactory().getApiResource("/file/" + fileId).delete();
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
		WebResource resource = getResourceFactory().getApiResource(
				"/file/app/" + appId + "/");
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
		WebResource resource = getResourceFactory().getApiResource(
				"/file/space/" + spaceId + "/");
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
