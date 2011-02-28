package com.podio.rating;

import java.util.List;

import com.podio.contact.ProfileMini;

public class ValueRatings {

	private int total;

	private List<ProfileMini> users;

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

	public List<ProfileMini> getUsers() {
		return users;
	}

	public void setUsers(List<ProfileMini> users) {
		this.users = users;
	}

}
