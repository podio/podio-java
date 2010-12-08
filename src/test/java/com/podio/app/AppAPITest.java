package com.podio.app;

import java.util.Arrays;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.junit.Assert;
import org.junit.Test;

import com.podio.BaseAPIFactory;

public class AppAPITest {

	private AppAPI getAPI() {
		return new AppAPI(BaseAPIFactory.get());
	}

	@Test
	public void getAppFull() throws JSONException {
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
	}

	@Test
	public void getAppShort() throws JSONException {
		Application app = getAPI().getApp(1, ApplicationGetType.SHORT);

		Assert.assertEquals(app.getId(), 1);
		Assert.assertNotNull(app.getConfiguration());
		Assert.assertEquals(app.getConfiguration().getDefaultView(),
				ApplicationViewType.BADGE);

		Assert.assertNull(app.getFields());
	}

	@Test
	public void addApp() {
		int appId = getAPI()
				.addApp(new ApplicationCreate(
						1,
						true,
						true,
						new ApplicationConfiguration("Tests", "Test",
								"Description", "Usage", "ExternalId", "23.png",
								true, ApplicationViewType.BADGE, true, true,
								false, null, false, false, null, false, null,
								false, null, Arrays.asList("Task 1", "Task 2")),
						Arrays.asList(new ApplicationFieldCreate(
								ApplicationFieldType.TITLE,
								new ApplicationFieldConfiguration("title",
										"Title", 0, null, true, true)))));
		Assert.assertTrue(appId > 0);
	}

	@Test
	public void updateApp() {
		getAPI().updateApp(
				1,
				new ApplicationUpdate(true, new ApplicationConfiguration(
						"Tests", "Test", "Description", "Usage", "ExternalId",
						"23.png", true, ApplicationViewType.BADGE, true, true,
						false, null, false, false, null, false, null, false,
						null, Arrays.asList("Task 1", "Task 2")), Arrays
						.asList(new ApplicationFieldUpdate(1,
								new ApplicationFieldConfiguration("hired",
										"Is hired?", 10,
										ApplicationFieldSettings
												.getState(Arrays.asList("yes",
														"no", "maybe")), true,
										true)))));
	}

	@Test
	public void getField() {
		ApplicationField field = getAPI().getField(1, 1);

		Assert.assertEquals(field.getId(), 1);
		Assert.assertEquals(field.getType(), ApplicationFieldType.STATE);
		Assert.assertEquals(field.getConfiguration().getName(), "hired");
		Assert.assertEquals(field.getConfiguration().getLabel(), "Is hired?");
		Assert.assertEquals(field.getConfiguration().getDelta(), 0);
		Assert.assertEquals(field.getConfiguration().getSettings()
				.getAllowedValues(), Arrays.asList("yes", "no"));
	}

	@Test
	public void addField() {
		int fieldId = getAPI().addField(
				1,
				new ApplicationFieldCreate(ApplicationFieldType.TEXT,
						new ApplicationFieldConfiguration("test",
								"Description", 0, ApplicationFieldSettings
										.getText(TextFieldSize.LARGE), true,
								true)));
		Assert.assertTrue(fieldId > 10);
	}

	@Test
	public void updateField() {
		getAPI().updateField(
				1,
				1,
				new ApplicationFieldConfiguration("hired", "Is hired?", 10,
						ApplicationFieldSettings.getState(Arrays.asList("yes",
								"no", "maybe")), true, true));
	}

	@Test
	public void deleteField() {
		getAPI().deleteField(1, 1);
	}

	@Test
	public void installApp() {
		int appId = getAPI().install(1, 1);
		Assert.assertTrue(appId > 1);

	}

	@Test
	public void updateOrder() {
		getAPI().updateOrder(1, Arrays.asList(1, 2));
	}

	@Test
	public void getAppsInSpace() {
		List<ApplicationMini> apps = getAPI().getAppsOnSpace(1);

		Assert.assertEquals(apps.size(), 1);
		Assert.assertEquals(apps.get(0).getId(), 1);
	}

	@Test
	public void getTopApps() {
		List<ApplicationMini> apps = getAPI().getTopApps(null);

		Assert.assertEquals(apps.size(), 1);
		Assert.assertEquals(apps.get(0).getId(), 1);
	}

	@Test
	public void getAvailableApps() {
		List<ApplicationMicro> apps = getAPI().getAvailableApps(1);
		Assert.assertEquals(apps.size(), 0);
	}

	@Test
	public void getAppDependencies() {
		Dependencies dependencies = getAPI().getDependencies(2);

		Assert.assertEquals(dependencies.getApps().size(), 1);
		Assert.assertEquals(dependencies.getDependencies().size(), 1);
		Assert.assertEquals(dependencies.getDependencies().get(1), null);
	}

	@Test
	public void deactivateApp() {
		getAPI().deactivateApp(1);
	}

	@Test
	public void activateApp() {
		getAPI().activateApp(2);
	}
}
