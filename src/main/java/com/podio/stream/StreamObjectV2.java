package com.podio.stream;

import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import com.podio.app.Application;
import com.podio.comment.Comment;
import com.podio.common.CreatedBase;
import com.podio.common.ReferenceType;
import com.podio.common.Right;
import com.podio.file.File;
import com.podio.org.OrganizationMini;
import com.podio.space.SpaceMini;

public class StreamObjectV2 extends CreatedBase {

	/**
	 * The type of object, either {@link ReferenceType.STATUS},
	 * {@link ReferenceType.ITEM} or {@link ReferenceType.TASK}
	 */
	private ReferenceType type;

	/**
	 * The id of the object
	 */
	private int id;

	/**
	 * The date and time the object was last updated
	 */
	private DateTime lastUpdateOn;

	/**
	 * The title of the object
	 */
	private String title;

	/**
	 * The link to the object
	 */
	private String link;

	/**
	 * The list of user rights on the status
	 */
	private List<Right> rights;

	/**
	 * The object itself in short form
	 */
	private HashMap<String, Object> data;

	/**
	 * <code>true</code> if comments are allowed, <code>false</code> otherwise
	 */
	private boolean commentsAllowed;

	/**
	 * The app this object belongs to, if any,
	 */
	private Application app;

	/**
	 * The space the object belongs to
	 */
	private SpaceMini space;

	/**
	 * The organization the object belongs to
	 */
	private OrganizationMini organization;

	/**
	 * The comments on the object
	 */
	private List<Comment> comments;

	/**
	 * Files attached to the object
	 */
	private List<File> files;

	/**
	 * The list of recent activities on the object
	 */
	private List<StreamActivity> activities;

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

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	public DateTime getLastUpdateOn() {
		return lastUpdateOn;
	}

	@JsonProperty("last_update_on")
	public void setLastUpdateOn(DateTime lastUpdateOn) {
		this.lastUpdateOn = lastUpdateOn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Right> getRights() {
		return rights;
	}

	public void setRights(List<Right> rights) {
		this.rights = rights;
	}

	public boolean isCommentsAllowed() {
		return commentsAllowed;
	}

	@JsonProperty("comments_allowed")
	public void setCommentsAllowed(boolean commentsAllowed) {
		this.commentsAllowed = commentsAllowed;
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

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public Application getApp() {
		return app;
	}

	public void setApp(Application app) {
		this.app = app;
	}

	public List<StreamActivity> getActivities() {
		return activities;
	}

	@JsonProperty("activity")
	public void setActivities(List<StreamActivity> activities) {
		this.activities = activities;
	}
}
