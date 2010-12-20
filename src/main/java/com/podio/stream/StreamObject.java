package com.podio.stream;

import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.comment.Comment;
import com.podio.common.ReferenceType;
import com.podio.file.File;
import com.podio.item.ItemRevision;
import com.podio.org.OrganizationMini;
import com.podio.rating.Rating;
import com.podio.space.SpaceMini;

public class StreamObject {

	/**
	 * The type of object, either {@link ReferenceType.STATUS} or
	 * {@link ReferenceType.ITEM}
	 */
	private ReferenceType type;

	/**
	 * The id of the object
	 */
	private int id;

	/**
	 * The object itself in short form
	 */
	private HashMap<String, Object> object;

	/**
	 * <code>true</code> if comments are allowed, <code>false</code> otherwise
	 */
	private boolean allowComments;

	/**
	 * The space the object belongs to
	 */
	private SpaceMini space;

	/**
	 * The organization the object belongs to
	 */
	private OrganizationMini organization;

	/**
	 * The link to the object
	 */
	private String link;

	/**
	 * The comments on the object
	 */
	private List<Comment> comments;

	/**
	 * Ratings within the last week
	 */
	private List<Rating> ratings;

	/**
	 * Files attached to the object
	 */
	private List<File> files;

	/**
	 * Revisions of the object, only valid for items
	 */
	private List<ItemRevision> revisions;

	public ReferenceType getType() {
		return type;
	}

	public void setType(ReferenceType type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HashMap<String, Object> getObject() {
		return object;
	}

	public void setObject(HashMap<String, Object> object) {
		this.object = object;
	}

	public boolean isAllowComments() {
		return allowComments;
	}

	@JsonProperty("allow_comments")
	public void setAllowComments(boolean allowComments) {
		this.allowComments = allowComments;
	}

	public SpaceMini getSpace() {
		return space;
	}

	public void setSpace(SpaceMini space) {
		this.space = space;
	}

	public OrganizationMini getOrganization() {
		return organization;
	}

	@JsonProperty("org")
	public void setOrganization(OrganizationMini organization) {
		this.organization = organization;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<ItemRevision> getRevisions() {
		return revisions;
	}

	public void setRevisions(List<ItemRevision> revisions) {
		this.revisions = revisions;
	}
}
