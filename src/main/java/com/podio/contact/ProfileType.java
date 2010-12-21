package com.podio.contact;

import com.podio.user.UserProfileMini;

public class ProfileType<T> {

	public static final ProfileType<Profile> FULL = new ProfileType<Profile>(
			"full", Profile.class);
	public static final ProfileType<ProfileShort> SHORT = new ProfileType<ProfileShort>(
			"short", ProfileShort.class);
	public static final ProfileType<UserProfileMini> MINI = new ProfileType<UserProfileMini>(
			"mini", UserProfileMini.class);

	private final String name;

	private final Class<T> type;

	public ProfileType(String name, Class<T> type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public Class<T> getType() {
		return type;
	}
}
