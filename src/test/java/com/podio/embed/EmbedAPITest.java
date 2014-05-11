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

		Assert.assertEquals(embed.getUrl(), "https://podio.com");
		Assert.assertEquals(embed.getType(), EmbedType.LINK);
		Assert.assertEquals(embed.getTitle(), "Podio - Work the way you want to");
		Assert.assertNotNull(embed.getDescription());
		Assert.assertTrue(embed.getFiles().size() > 0);

	}
}
