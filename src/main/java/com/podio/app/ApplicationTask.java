package com.podio.app;

import java.util.List;

import com.podio.user.UserMini;

public class ApplicationTask extends ApplicationTaskBase {

	private static final long serialVersionUID = 1L;

	private List<UserMini> responsible;

	public List<UserMini> getResponsible() {
		return responsible;
	}

	public void setResponsible(List<UserMini> responsible) {
		this.responsible = responsible;
	}
}
