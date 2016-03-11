package com.podio.search;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;
import com.sun.jersey.api.client.WebResource;

/**
 * This API makes it possible to search across Podio.
 */
public class SearchAPI extends BaseAPI {

	public SearchAPI(ResourceFactory resourceFactory) {
		super(resourceFactory);
	}

	/**
	 * Searches in all items, files, and tasks in the application. The objects 
         * will be returned sorted descending by the time the object had any update.
	 * 
	 * @param appId
	 *            The id of the app to be searched in
         * @param query
         *            The text to search for
         * @param limit
         *            The number of results to return; up to 20 results are returned in one call.
         * @param offset
         *            The rank of the first search result to return (default=0)
         * @param refType
         *            The type of objects to search for
         * @param counts
         *            True if the total counts should be returned
         * @param highlights
         *            True if the highlights for each result should be returned, false otherwise.
         * @param searchFields
         *            The list of fields to search in. Can f.ex. be used to limit the search to the "title" field.
	 * @return All items
	 */
	public SearchInAppResponse searchInApp(int appId, String query, Boolean counts, 
                Boolean highlights, Integer limit, Integer offset, ReferenceTypeSearchInApp refType,
                String searchFields) {
                WebResource resource = getResourceFactory().getApiResource("/search/app/" + appId + "/v2");
                resource = resource.queryParam("query", query);
                if (counts != null) {
                        resource = resource.queryParam("counts", counts ? "1" : "0");
		}
                if (highlights != null) {
                        resource = resource.queryParam("highlights", highlights ? "1" : "0");
		}
                if (limit != null) {
                        resource = resource.queryParam("limit", limit.toString());
		}
                if (offset != null) {
                        resource = resource.queryParam("offset", offset.toString());
		}
                if (refType != null) {
                        resource = resource.queryParam("ref_type", refType.toString());
                }
                if (searchFields != null && !searchFields.equals("")) {
                        resource = resource.queryParam("search_fields", searchFields);
                }
		return resource.get(SearchInAppResponse.class);
	}

}
