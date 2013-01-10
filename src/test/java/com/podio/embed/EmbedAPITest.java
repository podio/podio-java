package com.podio.embed;

import org.junit.Assert;
import org.junit.Test;

import com.podio.APIFactoryProvider;

public class EmbedAPITest {

	private EmbedAPI getAPI() {
		return APIFactoryProvider.getDefault().getAPI(EmbedAPI.class);
	}

	@Test
	public void createEmbed() {
		Embed embed = getAPI().createEmbed("https://podio.com");

		Assert.assertEquals(embed.getOriginalUrl(), "https://podio.com");
		Assert.assertEquals(embed.getResolvedUrl(), "https://podio.com/");
		Assert.assertEquals(embed.getType(), EmbedType.LINK);
		Assert.assertEquals(embed.getTitle(), "Podio");
		Assert.assertEquals(
				embed.getDescription(),
				"Podio is the online work platform. Manage, share, and get your work done smarter together with tools that work like you. Free for 10 Users.");
		Assert.assertNotNull(embed.getCreatedOn());
		Assert.assertEquals(embed.getProviderName(), "Podio");
		Assert.assertTrue(embed.getFiles().size() > 0);

	}
}
