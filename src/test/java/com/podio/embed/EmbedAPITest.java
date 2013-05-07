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
		Assert.assertEquals(embed.getResolvedUrl(), "https://podio.com");
		Assert.assertEquals(embed.getType(), EmbedType.LINK);
		Assert.assertEquals(embed.getTitle(), "Podio - Work the way you want to");
		Assert.assertEquals(
				embed.getDescription(),
				"Podio is built to work like you. Pick your apps - from simple project management, to handling sales leads, to tracking job candidates. You'll find hundreds more for any business process in the free Podio App Market. Organize your apps in unlimited workspaces. Add your team and even clients or contractors to get the job done together.");
		Assert.assertNotNull(embed.getCreatedOn());
		Assert.assertEquals(embed.getProviderName(), "Podio");
		Assert.assertTrue(embed.getFiles().size() > 0);

	}
}
