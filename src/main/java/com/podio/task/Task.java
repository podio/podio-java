package com.podio.task;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.podio.common.ReferenceType;
import com.podio.user.UserMini;

public class Task {

	/**
	 * The id of the task
	 */
	private int id;

	/**
	 * The status of the task
	 */
	private TaskStatus status;

	/**
	 * The text of the task
	 */
	private String text;

	/**
	 * True if the task is private, false otherwise
	 */
	private boolean priv;

	/**
	 * The due date of the task, if any
	 */
	private LocalDate dueDate;

	/**
	 * The user responsible for the task
	 */
	private UserMini responsible;

	/**
	 * The id of the space the task is on, if any
	 */
	private int spaceId;

	/**
	 * The link to the task
	 */
	private String link;

	/**
	 * The date and time the task was created
	 */
	private DateTime createdOn;

	/**
	 * The user who created the task
	 */
	private UserMini createdBy;

	/**
	 * The type of the reference, if any
	 */
	private ReferenceType refType;

	/**
	 * The id of the reference, if any
	 */
	private int refId;

	/**
	 * The title of the reference, if any
	 */
	private String refTitle;

	/**
	 * The direct link to the reference, if any
	 */
	private String refLink;

	@JsonProperty("task_id")
	public int getId() {
		return id;
	}

	@JsonProperty("task_id")
	public void setId(int id) {
		this.id = id;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@JsonProperty("private")
	public boolean isPrivate() {
		return priv;
	}

	@JsonProperty("private")
	public void setPrivate(boolean priv) {
		this.priv = priv;
	}

	@JsonProperty("due_date")
	public LocalDate getDueDate() {
		return dueDate;
	}

	@JsonProperty("due_date")
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public UserMini getResponsible() {
		return responsible;
	}

	public void setResponsible(UserMini responsible) {
		this.responsible = responsible;
	}

	@JsonProperty("space_id")
	public int getSpaceId() {
		return spaceId;
	}

	@JsonProperty("space_id")
	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@JsonProperty("created_on")
	public DateTime getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("created_on")
	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}

	@JsonProperty("created_by")
	public UserMini getCreatedBy() {
		return createdBy;
	}

	@JsonProperty("created_by")
	public void setCreatedBy(UserMini createdBy) {
		this.createdBy = createdBy;
	}

	@JsonProperty("ref_type")
	public ReferenceType getRefType() {
		return refType;
	}

	@JsonProperty("ref_type")
	public void setRefType(ReferenceType refType) {
		this.refType = refType;
	}

	@JsonProperty("ref_id")
	public int getRefId() {
		return refId;
	}

	@JsonProperty("ref_id")
	public void setRefId(int refId) {
		this.refId = refId;
	}

	@JsonProperty("ref_title")
	public String getRefTitle() {
		return refTitle;
	}

	@JsonProperty("ref_title")
	public void setRefTitle(String refTitle) {
		this.refTitle = refTitle;
	}

	@JsonProperty("ref_link")
	public String getRefLink() {
		return refLink;
	}

	@JsonProperty("ref_link")
	public void setRefLink(String refLink) {
		this.refLink = refLink;
	}
}
