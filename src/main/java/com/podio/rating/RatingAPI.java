package com.podio.rating;

import java.util.Collections;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;
import com.podio.common.Reference;

public class RatingAPI {

	private final BaseAPI baseAPI;

	public RatingAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	/**
	 * Add a new rating of the user to the object. The rating can be one of many
	 * different types. For more details see the area.
	 * 
	 * Ratings can be changed by posting a new rating, and deleted by doing a
	 * DELETE.
	 * 
	 * @param reference
	 *            The reference to the object the rating should be created on
	 * @param type
	 *            The type of the rating
	 * @param value
	 *            The value for the rating
	 * @return The id of the newly created rating
	 * 
	 * @see RatingValue
	 */
	public int createRating(Reference reference, RatingType type, int value) {
		return baseAPI
				.getApiResource("/rating/" + reference.toURLFragment() + type)
				.entity(Collections.singletonMap("value", value),
						MediaType.APPLICATION_JSON_TYPE)
				.post(RatingCreateResponse.class).getId();
	}

	/**
	 * Indicates that the active user likes the object
	 * 
	 * @param reference
	 *            The reference to the object that should be liked
	 * @return The id of the newly created rating
	 */
	public int like(Reference reference) {
		return createRating(reference, RatingType.LIKE, RatingValue.LIKE);
	}

	/**
	 * Returns all the ratings for the given object. It will only return the
	 * ratings that are enabled for the object.
	 * 
	 * @param reference
	 *            The reference to the object to get ratings for
	 * @return The map of rating types and their values
	 */
	public RatingValuesMap getAllRatings(Reference reference) {
		return baseAPI.getApiResource("/rating/" + reference.toURLFragment())
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(RatingValuesMap.class);
	}

	/**
	 * Get the rating average (for fivestar) and totals for the given rating
	 * type on the specified object.
	 * 
	 * @param reference
	 *            The reference to the object to get ratings for
	 * @param type
	 *            The type of rating to return
	 * @return The ratings for the type
	 */
	public TypeRating getRatings(Reference reference, RatingType type) {
		return baseAPI
				.getApiResource("/rating/" + reference.toURLFragment() + type)
				.accept(MediaType.APPLICATION_JSON_TYPE).get(TypeRating.class);
	}

	/**
	 * Returns the rating value for the given rating type, object and user.
	 * 
	 * @param reference
	 *            The reference to the object to get ratings for
	 * @param type
	 *            The type of rating to return
	 * @param userId
	 *            The id of the user for which to return the rating for
	 * @return The value of the rating
	 */
	public int getRating(Reference reference, RatingType type, int userId) {
		return baseAPI
				.getApiResource(
						"/rating/" + reference.toURLFragment() + type + "/"
								+ userId)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(SingleRatingValue.class).getValue();
	}
}
