package com.podio.status;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.podio.comment.Comment;
import com.podio.conversation.Conversation;
import com.podio.file.File;
import com.podio.rating.RatingType;
import com.podio.rating.RatingTypeKeyDeserializer;
import com.podio.rating.RatingValuesMap;
import com.podio.share.Share;
import com.podio.task.Task;
import com.podio.user.UserMini;

/**
 * A status message posted by a user to a space
 */
public class StatusFull extends Status {

	/**
	 * The alerts in the status message
	 */
	private List<UserMini> alerts;

	/**
	 * All the comments on the status
	 */
	private List<Comment> comments;

	/**
	 * The ratings on the status
	 */
	private RatingValuesMap ratings;

	/**
	 * All the conversations on the status that the user is part of
	 */
	private List<Conversation> conversations;

	/**
	 * The tasks on the status that are public or the user is part of
	 */
	private List<Task> tasks;

	/**
	 * The shares of the status
	 */
	private List<Share> shares;

	/**
	 * The files on the status
	 */
	private List<File> files;

	/**
	 * <code>true</code> if the user is subscribed to the item,
	 * <code>false</code> otherwise
	 */
	private boolean subscribed;

	/**
	 * The ratings and their values done by the active user on the status
	 */
	private Map<RatingType, Integer> userRatings;

	public List<UserMini> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<UserMini> alerts) {
		this.alerts = alerts;
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
