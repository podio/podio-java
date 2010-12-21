package com.podio.rating;

import java.util.List;

import com.podio.user.UserProfileMini;

public class ValueRatings {

	private int total;

	private List<UserProfileMini> users;

	@Override
	public String toString() {
		return "ValueRatings [total=" + total + ", users=" + users + "]";
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<UserProfileMini> getUsers() {
		return users;
	}

	public void setUsers(List<UserProfileMini> users) {
		this.users = users;
	}

}
