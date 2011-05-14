package com.podio.hook;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.podio.ResourceFactory;
import com.podio.common.Empty;
import com.podio.common.Reference;
import com.sun.jersey.api.client.GenericType;

public class HookAPI {

	private final ResourceFactory resourceFactory;

	public HookAPI(ResourceFactory resourceFactory) {
		this.resourceFactory = resourceFactory;
	}

	/**
	 * Create a new hook on the given object.
	 * 
	 * @param object
	 *            The reference to the object the hook should be created on
	 * @param create
	 *            The details for the new hook
	 * @return The id of the newly created hook
	 */
	public int create(Reference object, HookCreate create) {
		return resourceFactory
				.getApiResource(
						"/hook/" + object.getType() + "/" + object.getId()
								+ "/")
				.entity(create, MediaType.APPLICATION_JSON)
				.post(HookCreateResponse.class).getId();
	}

	/**
	 * Deletes the hook with the given id.
	 * 
	 * @param id
	 *            The id of the hook
	 */
	public void delete(int id) {
		resourceFactory.getApiResource("/hook/" + id).delete();
	}

	/**
	 * Returns the hooks on the object.
	 * 
	 * @param object
	 *            The reference to the object to get hooks for
	 * 
	 * @return The list of hooks on the object
	 */
	public List<Hook> get(Reference object) {
		return resourceFactory.getApiResource(
				"/hook/" + object.getType() + "/" + object.getId() + "/").get(
				new GenericType<List<Hook>>() {
				});
	}

	/**
	 * Request the hook to be validated. This will cause the hook to send a
	 * request to the URL with the parameter "type" set to "hook.verify" and
	 * "code" set to the verification code. The endpoint must then call the
	 * validate method with the code to complete the verification.
	 * 
	 * @param id
	 *            The id of the hook to be verified
	 */
	public void requestVerification(int id) {
		resourceFactory.getApiResource("/hook/" + id + "/verify/request")
				.entity(new Empty(), MediaType.APPLICATION_JSON_TYPE).post();
	}

	/**
	 * Validates the hook using the code received from the verify call. On
	 * successful validation the hook will become active.
	 * 
	 * @param id
	 *            The id of the hook to be verified
	 * @param code
	 *            The code received from the call to the endpoint
	 */
	public void validateVerification(int id, String code) {
		resourceFactory.getApiResource("/hook/" + id + "/verify/validate")
				.entity(new HookValidate(code), MediaType.APPLICATION_JSON)
				.post();
	}
}
