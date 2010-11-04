package com.podio.rating;

import java.util.List;

import com.podio.user.UserMini;

public class ValueRatings {

	private int total;

	private List<UserMini> users;

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

	public List<UserMini> getUsers() {
		return users;
	}

	public void setUsers(List<UserMini> users) {
		this.users = users;
	}

}
