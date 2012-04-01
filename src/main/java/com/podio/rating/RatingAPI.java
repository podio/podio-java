package com.podio.rating;

import java.util.Collections;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;
import com.podio.common.Reference;

/**
 * Many objects can be rated including items and status messages. Ratings can be
 * of different types and have different values.
 * 
 * @see RatingType
 * @see RatingValue
 */
public class RatingAPI extends BaseAPI {

	public RatingAPI(ResourceFactory resourceFactory) {
		super(resourceFactory);
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
		return getResourceFactory()
				.getApiResource("/rating/" + reference.toURLFragment() + type)
				.entity(Collections.singletonMap("value", value),
						MediaType.APPLICATION_JSON_TYPE)
				.post(RatingCreateResponse.class).getId();
	}

	/**
	 * Deletes the rating of the given type on the object by the active user
	 * 
	 * @param reference
	 *            The reference ot the object
	 * @param type
	 *            The type of the rating
	 */
	public void deleteRating(Reference reference, RatingType type) {
		getResourceFactory().getApiResource(
				"/rating/" + reference.toURLFragment() + type).delete();
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
	 * Indicates that the active user says "yes" to the object
	 * 
	 * @param reference
	 *            The reference to the object
	 * @return The id of the newly created rating
	 */
	public int yes(Reference reference) {
		return createRating(reference, RatingType.YESNO, RatingValue.YESNO_YES);
	}

	/**
	 * Indicates that the active user says "no" to the object
	 * 
	 * @param reference
	 *            The reference to the object
	 * @return The id of the newly created rating
	 */
	public int no(Reference reference) {
		return createRating(reference, RatingType.YESNO, RatingValue.YESNO_NO);
	}

	/**
	 * Indicates that the active user approves the object
	 * 
	 * @param reference
	 *            The reference to the object
	 * @return The id of the newly created rating
	 */
	public int approves(Reference reference) {
		return createRating(reference, RatingType.APPROVED,
				RatingValue.APPROVED_APPROVES);
	}

	/**
	 * Indicates that the active user disapproves the object
	 * 
	 * @param reference
	 *            The reference to the object
	 * @return The id of the newly created rating
	 */
	public int disapproves(Reference reference) {
		return createRating(reference, RatingType.APPROVED,
				RatingValue.APPROVED_DISAPPROVES);
	}

	/**
	 * Give a five star rating of the object
	 * 
	 * @param reference
	 *            The reference to the object
	 * @param stars
	 *            The number of stars to give, between 1 and 5
	 * @return The id of the newly created rating
	 */
	public int fivestar(Reference reference, int stars) {
		return createRating(reference, RatingType.FIVESTAR, stars);
	}

	/**
	 * Indicates that the active user will attend
	 * 
	 * @param reference
	 *            The reference to the object
	 * @return The id of the newly created rating
	 */
	public int attend(Reference reference) {
		return createRating(reference, RatingType.RSVP, RatingValue.RSVP_ATTEND);
	}

	/**
	 * Indicates that the active user will maybe attend
	 * 
	 * @param reference
	 *            The reference to the object
	 * @return The id of the newly created rating
	 */
	public int maybeAttend(Reference reference) {
		return createRating(reference, RatingType.RSVP,
				RatingValue.RSVP_MAYBE_ATTEND);
	}

	/**
	 * Indicates that the active user will not attend
	 * 
	 * @param reference
	 *            The reference to the object
	 * @return The id of the newly created rating
	 */
	public int notAttend(Reference reference) {
		return createRating(reference, RatingType.RSVP,
				RatingValue.RSVP_NOT_ATTEND);
	}

	/**
	 * Indicates that the active user give thumbs up to the object
	 * 
	 * @param reference
	 *            The reference to the object
	 * @return The id of the newly created rating
	 */
	public int thumbsUp(Reference reference) {
		return createRating(reference, RatingType.THUMBS, RatingValue.THUMBS_UP);
	}

	/**
	 * Indicates that the active user give thumbs down to the object
	 * 
	 * @param reference
	 *            The reference to the object
	 * @return The id of the newly created rating
	 */
	public int thumbsDown(Reference reference) {
		return createRating(reference, RatingType.THUMBS,
				RatingValue.THUMBS_DOWN);
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
		return getResourceFactory().getApiResource(
				"/rating/" + reference.toURLFragment()).get(
				RatingValuesMap.class);
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
		return getResourceFactory().getApiResource(
				"/rating/" + reference.toURLFragment() + type).get(
				TypeRating.class);
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
		return getResourceFactory()
				.getApiResource(
						"/rating/" + reference.toURLFragment() + type + "/"
								+ userId).get(SingleRatingValue.class)
				.getValue();
	}
}
