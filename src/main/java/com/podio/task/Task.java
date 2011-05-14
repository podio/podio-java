package com.podio.task;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.podio.common.AuthorizationEntity;
import com.podio.common.CreatedBase;
import com.podio.common.ReferenceType;
import com.podio.contact.ProfileMini;

public class Task extends CreatedBase {

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
	private ProfileMini responsible;

	/**
	 * The id of the space the task is on, if any
	 */
	private Integer spaceId;

	/**
	 * The link to the task
	 */
	private String link;

	/**
	 * The date and time the task was completed
	 */
	private DateTime completedOn;

	/**
	 * The user who created the task
	 */
	private AuthorizationEntity completedBy;

	/**
	 * The type of the reference, if any
	 */
	private ReferenceType referenceType;

	/**
	 * The id of the reference, if any
	 */
	private Integer referenceId;

	/**
	 * The title of the reference, if any
	 */
	private String referenceTitle;

	/**
	 * The direct link to the reference, if any
	 */
	private String referenceLink;

	@Override
	public String toString() {
		return "Task [id=" + id + ", status=" + status + ", text=" + text
				+ ", priv=" + priv + ", dueDate=" + dueDate + ", responsible="
				+ responsible + ", spaceId=" + spaceId + ", link=" + link
				+ ", referenceType=" + referenceType + ", referenceId="
				+ referenceId + ", referenceTitle=" + referenceTitle
				+ ", referenceLink=" + referenceLink + "]";
	}

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

	public ProfileMini getResponsible() {
		return responsible;
	}

	public void setResponsible(ProfileMini responsible) {
		this.responsible = responsible;
	}

	@JsonProperty("space_id")
	public Integer getSpaceId() {
		return spaceId;
	}

	@JsonProperty("space_id")
	public void setSpaceId(Integer spaceId) {
		this.spaceId = spaceId;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@JsonProperty("completed_on")
	public DateTime getCompletedOn() {
		return completedOn;
	}

	@JsonProperty("completed_on")
	public void setCompletedOn(DateTime completedOn) {
		this.completedOn = completedOn;
	}

	@JsonProperty("completed_by")
	public AuthorizationEntity getCompletedBy() {
		return completedBy;
	}

	@JsonProperty("completed_by")
	public void setCompletedBy(AuthorizationEntity completedBy) {
		this.completedBy = completedBy;
	}

	@JsonProperty("ref_type")
	public ReferenceType getReferenceType() {
		return referenceType;
	}

	@JsonProperty("ref_type")
	public void setReferenceType(ReferenceType refeferenceType) {
		this.referenceType = refeferenceType;
	}

	@JsonProperty("ref_id")
	public Integer getReferenceId() {
		return referenceId;
	}

	@JsonProperty("ref_id")
	public void setReferenceId(Integer referenceId) {
		this.referenceId = referenceId;
	}

	@JsonProperty("ref_title")
	public String getReferenceTitle() {
		return referenceTitle;
	}

	@JsonProperty("ref_title")
	public void setReferenceTitle(String referenceTitle) {
		this.referenceTitle = referenceTitle;
	}

	@JsonProperty("ref_link")
	public String getReferenceLink() {
		return referenceLink;
	}

	@JsonProperty("ref_link")
	public void setReferenceLink(String referenceLink) {
		this.referenceLink = referenceLink;
	}
}
