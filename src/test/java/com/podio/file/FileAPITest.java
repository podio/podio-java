package com.podio.file;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

import com.podio.ResourceFactoryProvider;
import com.podio.common.ReferenceType;

public class FileAPITest {

	private FileAPI getAPI() {
		return new FileAPI(ResourceFactoryProvider.get());
	}

	@Test
	public void getFile() {
		File file = getAPI().getFile(3);

		Assert.assertEquals(file.getId(), 3);
		Assert.assertEquals(file.getDescription(),
				"Party poster in PNG instead");
		Assert.assertEquals(file.getMimetype().getPrimaryType(), "image");
		Assert.assertEquals(file.getMimetype().getSubType(), "png");
		Assert.assertEquals(file.getName(), "party_poster.png");
		Assert.assertEquals(file.getSize(), 127445);
		Assert.assertEquals(file.getCreatedBy().getId(), 1);
		Assert.assertEquals(file.getCreatedOn(), new DateTime(2010, 8, 13, 14,
				46, 0, 0, DateTimeZone.UTC));
		Assert.assertEquals(file.getReplaces().size(), 1);
		Assert.assertEquals(file.getReplaces().get(0).getId(), 2);
	}

	@Test
	public void deleteFile() {
		getAPI().deleteFile(3);
	}

	@Test
	public void updateFile() {
		getAPI().updateFile(3, new FileUpdate("New description"));
	}

	@Test
	public void getLatestOnSpace() {
		List<File> files = getAPI().getLatestOnSpace(1, null, null);
		Assert.assertEquals(files.size(), 4);

		File file = files.get(0);
		Assert.assertEquals(file.getData().getId(), 1);
		Assert.assertEquals(file.getData().getType(), ReferenceType.ITEM);
		Assert.assertEquals(file.getData().getTitle(), "זרו");
		Assert.assertEquals(file.getContext().getId(), 1);
		Assert.assertEquals(file.getContext().getType(), ReferenceType.ITEM);
		Assert.assertEquals(file.getContext().getTitle(), "זרו");
	}

	@Test
	public void getLatestOnApp() {
		List<File> files = getAPI().getLatestOnApp(1, null, null);
		Assert.assertEquals(files.size(), 1);

		File file = files.get(0);
		Assert.assertEquals(file.getData().getId(), 1);
		Assert.assertEquals(file.getData().getType(), ReferenceType.ITEM);
		Assert.assertEquals(file.getData().getTitle(), "זרו");
		Assert.assertEquals(file.getContext().getId(), 1);
		Assert.assertEquals(file.getContext().getType(), ReferenceType.ITEM);
		Assert.assertEquals(file.getContext().getTitle(), "זרו");
	}

	@Test
	public void getOnSpace() {
		List<File> files = getAPI().getOnSpace(1, null, null);
		Assert.assertEquals(files.size(), 4);

		File file = files.get(0);
		Assert.assertEquals(file.getData().getId(), 4);
	}

	@Test
	public void getOnApp() {
		List<File> files = getAPI().getOnApp(1, null, null);
		Assert.assertEquals(files.size(), 1);

		File file = files.get(0);
		Assert.assertEquals(file.getData().getId(), 1);
	}
}
