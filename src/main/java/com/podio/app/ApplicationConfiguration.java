package com.podio.app;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

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

	public ApplicationConfiguration() {
		super();
	}

	public ApplicationConfiguration(String name, String itemName,
			String description, String usage, String externalId, String icon,
			boolean allowEdit, boolean allowInsert,
			ApplicationViewType defaultView, boolean allowAttachments,
			boolean allowComments, boolean visible, boolean fivestar,
			String fivestarLabel, boolean approved, boolean thumbs,
			String thumbsLabel, boolean rsvp, String rsvpLabel, boolean yesno,
			String yesnoLabel, List<String> tasks) {
		super();
		this.name = name;
		this.itemName = itemName;
		this.description = description;
		this.usage = usage;
		this.externalId = externalId;
		this.icon = icon;
		this.allowEdit = allowEdit;
		this.allowInsert = allowInsert;
		this.defaultView = defaultView;
		this.allowAttachments = allowAttachments;
		this.allowComments = allowComments;
		this.visible = visible;
		this.fivestar = fivestar;
		this.fivestarLabel = fivestarLabel;
		this.approved = approved;
		this.thumbs = thumbs;
		this.thumbsLabel = thumbsLabel;
		this.rsvp = rsvp;
		this.rsvpLabel = rsvpLabel;
		this.yesno = yesno;
		this.yesnoLabel = yesnoLabel;
		this.tasks = tasks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("item_name")
	public String getItemName() {
		return itemName;
	}

	@JsonProperty("item_name")
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	@JsonProperty("external_id")
	public String getExternalId() {
		return externalId;
	}

	@JsonProperty("external_id")
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@JsonProperty("allow_edit")
	public boolean isAllowEdit() {
		return allowEdit;
	}

	@JsonProperty("allow_edit")
	public void setAllowEdit(boolean allowEdit) {
		this.allowEdit = allowEdit;
	}

	@JsonProperty("allow_insert")
	public boolean isAllowInsert() {
		return allowInsert;
	}

	@JsonProperty("allow_insert")
	public void setAllowInsert(boolean allowInsert) {
		this.allowInsert = allowInsert;
	}

	@JsonProperty("default_view")
	public ApplicationViewType getDefaultView() {
		return defaultView;
	}

	@JsonProperty("default_view")
	public void setDefaultView(ApplicationViewType defaultView) {
		this.defaultView = defaultView;
	}

	@JsonProperty("allow_attachments")
	public boolean isAllowAttachments() {
		return allowAttachments;
	}

	@JsonProperty("allow_attachments")
	public void setAllowAttachments(boolean allowAttachments) {
		this.allowAttachments = allowAttachments;
	}

	@JsonProperty("allow_comments")
	public boolean isAllowComments() {
		return allowComments;
	}

	@JsonProperty("allow_comments")
	public void setAllowComments(boolean allowComments) {
		this.allowComments = allowComments;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isFivestar() {
		return fivestar;
	}

	public void setFivestar(boolean fivestar) {
		this.fivestar = fivestar;
	}

	@JsonProperty("fivestar_label")
	public String getFivestarLabel() {
		return fivestarLabel;
	}

	@JsonProperty("fivestar_label")
	public void setFivestarLabel(String fivestarLabel) {
		this.fivestarLabel = fivestarLabel;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public boolean isThumbs() {
		return thumbs;
	}

	public void setThumbs(boolean thumbs) {
		this.thumbs = thumbs;
	}

	@JsonProperty("thumbs_label")
	public String getThumbsLabel() {
		return thumbsLabel;
	}

	@JsonProperty("thumbs_label")
	public void setThumbsLabel(String thumbsLabel) {
		this.thumbsLabel = thumbsLabel;
	}

	public boolean isRsvp() {
		return rsvp;
	}

	public void setRsvp(boolean rsvp) {
		this.rsvp = rsvp;
	}

	@JsonProperty("rsvp_label")
	public String getRsvpLabel() {
		return rsvpLabel;
	}

	@JsonProperty("rsvp_label")
	public void setRsvpLabel(String rsvpLabel) {
		this.rsvpLabel = rsvpLabel;
	}

	public boolean isYesno() {
		return yesno;
	}

	public void setYesno(boolean yesno) {
		this.yesno = yesno;
	}

	@JsonProperty("yesno_label")
	public String getYesnoLabel() {
		return yesnoLabel;
	}

	@JsonProperty("yesno_label")
	public void setYesnoLabel(String yesnoLabel) {
		this.yesnoLabel = yesnoLabel;
	}

	public List<String> getTasks() {
		return tasks;
	}

	public void setTasks(List<String> tasks) {
		this.tasks = tasks;
	}
}
