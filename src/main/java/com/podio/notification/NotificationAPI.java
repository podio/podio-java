package com.podio.notification;

import com.podio.BaseAPI;

public class NotificationAPI {

	private final BaseAPI baseAPI;

	public NotificationAPI(BaseAPI baseAPI) {
		this.baseAPI = baseAPI;
	}

	public Notification getNotification(int notificationId) {
		return baseAPI.getApiResource("/notification/" + notificationId).get(
				Notification.class);
	}
}
