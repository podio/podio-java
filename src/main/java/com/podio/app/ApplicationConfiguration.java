package com.podio.app;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApplicationConfiguration {

	/**
	 * The name of the app
	 */
	private String name;

	/**
	 * The name of each item in an app
	 */
	private String itemName;

	/**
	 * The description of the app
	 */
	private String description;

	/**
	 * Description of how the app should be used
	 */
	private String usage;

	/**
	 * The external id of the app. This can be used to store an id from an
	 * external system on the app
	 */
	private String externalId;

	/**
	 * The name of the icon used to represent the app
	 */
	private String icon;

	/**
	 * True if other members are allowed to edit items from the app, false
	 * otherwise
	 */
	private boolean allowEdit;

	/**
	 * True if other members are allowed to add new items to the app, false
	 * otherwise,
	 */
	private boolean allowInsert;

	/**
	 * The default view of the app items on the app main page (see area for more
	 * information),
	 */
	private ApplicationViewType defaultView;

	/**
	 * True if attachment of files to an item is allowed, false otherwise
	 */
	private boolean allowAttachments;

	/**
	 * True if members can make comments on an item, false otherwise
	 */
	private boolean allowComments;

	/**
	 * True if the app is visible, false otherwise (might be removed in a future
	 * version),
	 */
	private boolean visible;

	/**
	 * True if fivestar rating is enabled on an item, false otherwise
	 */
	private boolean fivestar;

	/**
	 * If fivestar rating is enabled, this is the label that will be presented
	 * to the users
	 */
	private String fivestarLabel;

	/**
	 * True if an item can be approved, false otherwise
	 */
	private boolean approved;

	/**
	 * True if an item can have a thumbs up or thumbs down, false otherwise
	 */
	private boolean thumbs;

	/**
	 * If thumbs ratings are enabled, this is the label that will be presented
	 * to the users
	 */
	private String thumbsLabel;

	/**
	 * True if RSVP is enabled, false otherwise
	 */
	private boolean rsvp;

	/**
	 * If RSVP is enabled, this is the label that will be presented to the users
	 */
	private String rsvpLabel;

	/**
	 * True if yes/no rating is enabled, false otherwise
	 */
	private boolean yesno;

	/**
	 * If yes/no is enabled, this is the label that will be presented to the
	 * users
	 */
	private String yesnoLabel;

	/**
	 * A comma separated list of the tasks that will automatically be created
	 * when a new item is added
	 */
	private List<String> tasks;

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "item_name")
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@XmlElement(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name = "usage")
	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	@XmlElement(name = "external_id")
	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	@XmlElement(name = "icon")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@XmlElement(name = "allow_edit")
	public boolean isAllowEdit() {
		return allowEdit;
	}

	public void setAllowEdit(boolean allowEdit) {
		this.allowEdit = allowEdit;
	}

	@XmlElement(name = "insert")
	public boolean isAllowInsert() {
		return allowInsert;
	}

	public void setAllowInsert(boolean allowInsert) {
		this.allowInsert = allowInsert;
	}

	@XmlElement(name = "default_view")
	public ApplicationViewType getDefaultView() {
		return defaultView;
	}

	public void setDefaultView(ApplicationViewType defaultView) {
		this.defaultView = defaultView;
	}

	@XmlElement(name = "allow_attachments")
	public boolean isAllowAttachments() {
		return allowAttachments;
	}

	public void setAllowAttachments(boolean allowAttachments) {
		this.allowAttachments = allowAttachments;
	}

	@XmlElement(name = "allow_comments")
	public boolean isAllowComments() {
		return allowComments;
	}

	public void setAllowComments(boolean allowComments) {
		this.allowComments = allowComments;
	}

	@XmlElement(name = "visible")
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@XmlElement(name = "fivestar")
	public boolean isFivestar() {
		return fivestar;
	}

	public void setFivestar(boolean fivestar) {
		this.fivestar = fivestar;
	}

	@XmlElement(name = "fivestar_label")
	public String getFivestarLabel() {
		return fivestarLabel;
	}

	public void setFivestarLabel(String fivestarLabel) {
		this.fivestarLabel = fivestarLabel;
	}

	@XmlElement(name = "approved")
	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@XmlElement(name = "thumbs")
	public boolean isThumbs() {
		return thumbs;
	}

	public void setThumbs(boolean thumbs) {
		this.thumbs = thumbs;
	}

	@XmlElement(name = "thumbs_label")
	public String getThumbsLabel() {
		return thumbsLabel;
	}

	public void setThumbsLabel(String thumbsLabel) {
		this.thumbsLabel = thumbsLabel;
	}

	@XmlElement(name = "rsvp")
	public boolean isRsvp() {
		return rsvp;
	}

	public void setRsvp(boolean rsvp) {
		this.rsvp = rsvp;
	}

	@XmlElement(name = "rsvp_label")
	public String getRsvpLabel() {
		return rsvpLabel;
	}

	public void setRsvpLabel(String rsvpLabel) {
		this.rsvpLabel = rsvpLabel;
	}

	@XmlElement(name = "yesno")
	public boolean isYesno() {
		return yesno;
	}

	public void setYesno(boolean yesno) {
		this.yesno = yesno;
	}

	@XmlElement(name = "yesno_label")
	public String getYesnoLabel() {
		return yesnoLabel;
	}

	public void setYesnoLabel(String yesnoLabel) {
		this.yesnoLabel = yesnoLabel;
	}

	@XmlElement(name = "tasks")
	public List<String> getTasks() {
		return tasks;
	}

	public void setTasks(List<String> tasks) {
		this.tasks = tasks;
	}

}
