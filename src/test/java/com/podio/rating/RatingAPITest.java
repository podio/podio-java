package com.podio.rating;

import org.junit.Assert;
import org.junit.Test;

import com.podio.ResourceFactoryProvider;
import com.podio.common.Reference;
import com.podio.common.ReferenceType;

public class RatingAPITest {

	private RatingAPI getAPI() {
		return new RatingAPI(ResourceFactoryProvider.get());
	}

	@Test
	public void createRating() {
		int ratingId = getAPI().createRating(
				new Reference(ReferenceType.STATUS, 1), RatingType.LIKE,
				RatingValue.LIKE);

		Assert.assertTrue(ratingId > 1);
	}

	@Test
	public void getAllRatings() {
		RatingValuesMap ratings = getAPI().getAllRatings(
				new Reference(ReferenceType.STATUS, 1));

		Assert.assertEquals(ratings.get(RatingType.LIKE).getCounts(1)
				.getTotal(), 1);
		Assert.assertEquals(ratings.get(RatingType.LIKE).getCounts(1)
				.getUsers().get(0).getId(), 3);
	}

	@Test
	public void getRatings() {
		TypeRating ratings = getAPI().getRatings(
				new Reference(ReferenceType.STATUS, 1), RatingType.LIKE);

		Assert.assertEquals(ratings.getCounts(1).getTotal(), 1);
	}

	@Test
	public void getRating() {
		int value = getAPI().getRating(new Reference(ReferenceType.STATUS, 1),
				RatingType.LIKE, 3);

		Assert.assertEquals(value, 1);
	}

	@Test
	public void deleteRating() {
		getAPI().deleteRating(new Reference(ReferenceType.ITEM, 1),
				RatingType.APPROVED);
	}
}
