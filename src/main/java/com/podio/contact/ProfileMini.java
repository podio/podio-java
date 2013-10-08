package com.podio.contact;


public class ProfileMini extends ProfileBase {

	private static final long serialVersionUID = 1L;

	private Integer avatar;

	private String name;

	@Override
	public String toString() {
		return "ProfileMini [profileId=" + getProfileId() + ", avatar="
				+ avatar + ", name=" + name + "]";
	}

	public Integer getAvatar() {
		return avatar;
	}

	public void setAvatar(Integer avatar) {
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
