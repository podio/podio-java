package com.podio.rating;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.podio.user.UserMini;

@XmlRootElement
public class ValueRatings {

	private int total;

	private List<UserMini> users;

	@XmlElement(name = "total")
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@XmlElement(name = "users")
	public List<UserMini> getUsers() {
		return users;
	}

	public void setUsers(List<UserMini> users) {
		this.users = users;
	}

}
