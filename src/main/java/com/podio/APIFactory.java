package com.podio;

import com.podio.app.AppAPI;
import com.podio.calendar.CalendarAPI;
import com.podio.comment.CommentAPI;
import com.podio.contact.ContactAPI;
import com.podio.conversation.ConversationAPI;
import com.podio.file.FileAPI;
import com.podio.item.ItemAPI;
import com.podio.item.map.MappedItemAPI;
import com.podio.notification.NotificationAPI;
import com.podio.org.OrgAPI;
import com.podio.rating.RatingAPI;
import com.podio.root.RootAPI;
import com.podio.space.SpaceAPI;
import com.podio.status.StatusAPI;
import com.podio.stream.StreamAPI;
import com.podio.subscription.SubscriptionAPI;
import com.podio.tag.TagAPI;
import com.podio.task.TaskAPI;
import com.podio.user.UserAPI;

/**
 * Factory to make it simple to get a specific API to work with
 */
public class APIFactory {

	private final ResourceFactory resourceFactory;

	public APIFactory(ResourceFactory resourceFactory) {
		super();
		this.resourceFactory = resourceFactory;
	}

	public AppAPI getAppAPI() {
		return new AppAPI(resourceFactory);
	}

	public CalendarAPI getCalendarAPI() {
		return new CalendarAPI(resourceFactory);
	}

	public CommentAPI getCommentAPI() {
		return new CommentAPI(resourceFactory);
	}

	public ContactAPI getContactAPI() {
		return new ContactAPI(resourceFactory);
	}

	public ConversationAPI getConversationAPI() {
		return new ConversationAPI(resourceFactory);
	}

	public FileAPI getFileAPI() {
		return new FileAPI(resourceFactory);
	}

	public ItemAPI getItemAPI() {
		return new ItemAPI(resourceFactory);
	}

	public <T> MappedItemAPI<T> getMappedItemAPI(int appId, Class<T> cls) {
		return new MappedItemAPI<T>(this, appId, cls);
	}

	public NotificationAPI getNotificationAPI() {
		return new NotificationAPI(resourceFactory);
	}

	public OrgAPI getOrgAPI() {
		return new OrgAPI(resourceFactory);
	}

	public RatingAPI getRatingAPI() {
		return new RatingAPI(resourceFactory);
	}

	public RootAPI getRootAPI() {
		return new RootAPI(resourceFactory);
	}

	public SpaceAPI getSpaceAPI() {
		return new SpaceAPI(resourceFactory);
	}

	public StatusAPI getStatusAPI() {
		return new StatusAPI(resourceFactory);
	}

	public SubscriptionAPI getSubscriptionAPI() {
		return new SubscriptionAPI(resourceFactory);
	}

	public TagAPI getTagAPI() {
		return new TagAPI(resourceFactory);
	}

	public TaskAPI getTaskAPI() {
		return new TaskAPI(resourceFactory);
	}

	public UserAPI getUserAPI() {
		return new UserAPI(resourceFactory);
	}

	public StreamAPI getStreamAPI() {
		return new StreamAPI(resourceFactory);
	}
}
