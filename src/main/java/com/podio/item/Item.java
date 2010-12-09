package com.podio.item;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.podio.app.ApplicationMicro;
import com.podio.comment.Comment;
import com.podio.conversation.Conversation;
import com.podio.file.File;
import com.podio.rating.RatingType;
import com.podio.rating.RatingTypeKeyDeserializer;
import com.podio.rating.RatingValuesMap;
import com.podio.share.Share;
import com.podio.task.Task;

public class Item {

	/**
	 * The id of the item
	 */
	private int id;

	/**
	 * The app where the item belongs
	 */
	private ApplicationMicro application;

	/**
	 * The external id of the item. This can be used to hold a reference to the
	 * item in an external system.
	 */
	private String externalId;

	/**
	 * The information on who created the first revision of the item
	 */
	private ItemRevision initialRevision;

	/**
	 * The latest revision
	 */
	private ItemRevision currentRevision;

	/**
	 * The title of the item. This is made of up one of the fields below, or by
	 * the item name and id
	 */
	private String title;

	/**
	 * The values for each field
	 */
	private List<FieldValuesView> fields;

	/**
	 * The latest 8 revisions of the item sorted descending by date
	 */
	private List<ItemRevision> revisions;

	/**
	 * All the comments on the item
	 */
	private List<Comment> comments;

	/**
	 * The ratings on the item
	 */
	private RatingValuesMap ratings;

	/**
	 * All the conversations on the item that the user is part of
	 */
	private List<Conversation> conversations;

	/**
	 * The tasks on the item that are public or the user is part of
	 */
	private List<Task> tasks;

	/**
	 * The shares of the item
	 */
	private List<Share> shares;

	/**
	 * The files on the item
	 */
	private List<File> files;

	/**
	 * The items that reference this item
	 */
	private List<ItemReference> references;

	/**
	 * The tags on the item
	 */
	private List<String> tags;

	/**
	 * <code>true</code> if the user is subscribed to the item,
	 * <code>false</code> otherwise
	 */
	private boolean subscribed;

	/**
	 * The ratings and their values done by the active user on the item
	 */
	private Map<RatingType, Integer> userRatings;

	@JsonProperty("item_id")
	public int getId() {
		return id;
	}

	@JsonProperty("item_id")
	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("app")
	public ApplicationMicro getApplication() {
		return application;
	}

	@JsonProperty("app")
	public void setApplication(ApplicationMicro application) {
		this.application = application;
	}

	@JsonProperty("external_id")
	public String getExternalId() {
		return externalId;
	}

	@JsonProperty("external_id")
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	@JsonProperty("initial_revision")
	public ItemRevision getInitialRevision() {
		return initialRevision;
	}

	@JsonProperty("initial_revision")
	public void setInitialRevision(ItemRevision initialRevision) {
		this.initialRevision = initialRevision;
	}

	@JsonProperty("current_revision")
	public ItemRevision getCurrentRevision() {
		return currentRevision;
	}

	@JsonProperty("current_revision")
	public void setCurrentRevision(ItemRevision currentRevision) {
		this.currentRevision = currentRevision;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<FieldValuesView> getFields() {
		return fields;
	}

	public void setFields(List<FieldValuesView> fields) {
		this.fields = fields;
	}

	public List<ItemRevision> getRevisions() {
		return revisions;
	}

	public void setRevisions(List<ItemRevision> revisions) {
		this.revisions = revisions;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public RatingValuesMap getRatings() {
		return ratings;
	}

	public void setRatings(RatingValuesMap ratings) {
		this.ratings = ratings;
	}

	public List<Conversation> getConversations() {
		return conversations;
	}

	public void setConversations(List<Conversation> conversations) {
		this.conversations = conversations;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Share> getShares() {
		return shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<ItemReference> getReferences() {
		return references;
	}

	public void setReferences(List<ItemReference> references) {
		this.references = references;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	public Integer getUserRating(RatingType type) {
		return userRatings.get(type);
	}

	public Map<RatingType, Integer> getUserRatings() {
		return userRatings;
	}

	@JsonDeserialize(keyUsing = RatingTypeKeyDeserializer.class)
	@JsonProperty("user_ratings")
	public void setUserRatings(Map<RatingType, Integer> userRatings) {
		this.userRatings = userRatings;
	}
}
