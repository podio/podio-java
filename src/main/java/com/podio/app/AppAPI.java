package com.podio.app;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;

public class AppAPI {

	private final BaseAPI baseAPI;

	public AppAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	public Application getApp(int appId) {
		return getApp(appId, "full");
	}

	public Application getApp(int appId, String type) {
		return baseAPI.getApiResource("/app/" + appId).queryParam("type", type)
				.accept(MediaType.APPLICATION_JSON_TYPE).get(Application.class);
	}

	public ApplicationCreateResponse addApp(ApplicationCreate app) {
		return baseAPI.getApiResource("/app/")
				.entity(app, MediaType.APPLICATION_JSON_TYPE)
				.post(ApplicationCreateResponse.class);
	}

	public void updateApp(int appId, ApplicationUpdate app) {
		baseAPI.getApiResource("/app/" + appId)
				.entity(app, MediaType.APPLICATION_JSON).put();
	}

	public ApplicationFieldCreateResponse addField(int appId,
			ApplicationFieldCreate field) {
		return baseAPI.getApiResource("/app/" + appId + "/field/")
				.entity(field, MediaType.APPLICATION_JSON_TYPE)
				.post(ApplicationFieldCreateResponse.class);
	}

	public void updateField(int appId, int fieldId,
			ApplicationFieldConfiguration configuration) {
		baseAPI.getApiResource("/app/" + appId + "/field/" + fieldId)
				.entity(configuration, MediaType.APPLICATION_JSON_TYPE).put();
	}

	public ApplicationField getField(int appId, int fieldId) {
		return baseAPI.getApiResource("/app/" + appId + "/field/" + fieldId)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(ApplicationField.class);
	}

	public void deleteField(int appId, int fieldId) {
		baseAPI.getApiResource("/app/" + appId + "/field/" + fieldId).delete();
	}

	public ApplicationCreateResponse install(int appId,
			ApplicationInstall install) {
		return baseAPI.getApiResource("/app/" + appId + "/install")
				.entity(install, MediaType.APPLICATION_JSON_TYPE)
				.post(ApplicationCreateResponse.class);
	}
}
