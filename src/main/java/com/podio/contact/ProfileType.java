package com.podio.contact;

public class ProfileType<T> {

	public static final ProfileType<Profile> FULL = new ProfileType<Profile>(
			"full", Profile.class);
	public static final ProfileType<ProfileMini> MINI = new ProfileType<ProfileMini>(
			"mini", ProfileMini.class);

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
