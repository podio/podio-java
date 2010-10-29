package com.podio.app;

import junit.framework.Assert;

import org.codehaus.jettison.json.JSONException;
import org.junit.Test;

import com.podio.BaseAPIFactory;

public class AppAPITest {

	private AppAPI getAPI() {
		return new AppAPI(BaseAPIFactory.get());
	}

	@Test
	public void getApp() throws JSONException {
		Application app = getAPI().getApp(1);

		Assert.assertEquals(app.getId(), 1);
		Assert.assertNotNull(app.getConfiguration());
		Assert.assertEquals(app.getConfiguration().getDefaultView(),
				ApplicationViewType.BADGE);

		Assert.assertEquals(app.getFields().size(), 10);
		ApplicationField stateField = app.getFields().get(0);
		Assert.assertEquals(stateField.getType(), ApplicationFieldType.STATE);
		Assert.assertEquals(stateField.getConfiguration().getLabel(),
				"Is hired?");
		System.out.println(stateField.getConfiguration().getSettings()
				.getClass());
		System.out.println(stateField.getConfiguration().getSettings());
	}
}
