package com.podio.embed;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;
import com.podio.ResourceFactory;

/**
 * Embeds are links shared by users in statuses, conversations and comments. One
 * or more embeds are also referred when creating items with an embed file type.
 */
public class EmbedAPI extends BaseAPI {

	public EmbedAPI(ResourceFactory resourceFactory) {
		super(resourceFactory);
	}

	/**
	 * Grabs metadata and returns metadata for the given url such as title,
	 * description and thumbnails.
	 * 
	 * @param url
	 *            The URL of the embed
	 * @return The full embed data
	 */
	public Embed createEmbed(String url) {
		return getResourceFactory().getApiResource("/embed/")
				.entity(new EmbedCreate(url), MediaType.APPLICATION_JSON_TYPE)
				.post(Embed.class);
	}
}
