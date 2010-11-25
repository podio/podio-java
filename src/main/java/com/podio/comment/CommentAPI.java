package com.podio.comment;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.podio.BaseAPI;
import com.podio.common.Reference;
import com.sun.jersey.api.client.GenericType;

/**
 * Comments are made by users on different objects. Objects can f.ex. be items,
 * status, etc. Comments is simply a text that can be any length.
 * 
 * Comments are made from the API of the object, see f.ex. Items for more
 * details. Comments are however updated and deleted from the comment API.
 */
public class CommentAPI {

	private final BaseAPI baseAPI;

	public CommentAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	/**
	 * Used to retrieve all the comments that have been made on an object of the
	 * given type and with the given id. It returns a list of all the comments
	 * sorted in ascending order by time created.
	 */
	public List<Comment> getComments(Reference reference) {
		return baseAPI
				.getApiResource(
						"/comment/" + reference.getType() + "/"
								+ reference.getId())
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(new GenericType<List<Comment>>() {
				});
	}

	/**
	 * Returns the contents of a comment. It is not possible to see where the
	 * comment was made, only the comment itself.
	 */
	public Comment getComment(int commentId) {
		return baseAPI.getApiResource("/comment/" + commentId)
				.accept(MediaType.APPLICATION_JSON_TYPE).get(Comment.class);
	}

	/**
	 * Adds a new comment to the object of the given type and id, f.ex. item 1.
	 * 
	 * @param reference
	 *            The reference to the object the comment should be added to
	 * @param comment
	 *            The comment that should be added
	 * @param silent
	 *            True if the update should be silent, false otherwise
	 */
	public int addComment(Reference reference, CommentCreate comment,
			boolean silent) {
		return baseAPI
				.getApiResource(
						"/comment/" + reference.getType() + "/"
								+ reference.getId())
				.queryParam("silent", silent ? "1" : "0")
				.entity(comment, MediaType.APPLICATION_JSON_TYPE)
				.post(CommentCreateResponse.class).getId();
	}

	/**
	 * Updates an already created comment. This should only be used to correct
	 * spelling and grammatical mistakes in the comment.
	 */
	public void updateComment(int commentId, CommentUpdate comment) {
		baseAPI.getApiResource("/comment/" + commentId)
				.entity(comment, MediaType.APPLICATION_JSON_TYPE).put();
	}

	/**
	 * Deletes a comment made by a user. This can be used to retract a comment
	 * that was made and which the user regrets.
	 */
	public void deleteComment(int commentId) {
		baseAPI.getApiResource("/comment/" + commentId).delete();
	}
}
