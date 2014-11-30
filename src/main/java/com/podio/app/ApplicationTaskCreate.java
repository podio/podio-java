package com.podio.app;

import java.util.Arrays;
import java.util.List;

public class ApplicationTaskCreate extends ApplicationTaskBase {

	private static final long serialVersionUID = 1L;

	private List<Integer> responsible;

	public ApplicationTaskCreate() {
		super();
	}

	public ApplicationTaskCreate(String text, Integer... responsible) {
		this(text, Arrays.asList(responsible));
	}

	public ApplicationTaskCreate(String text, List<Integer> responsible) {
		super(text);
		this.responsible = responsible;
	}

	public List<Integer> getResponsible() {
		return responsible;
	}

	public void setResponsible(List<Integer> responsible) {
		this.responsible = responsible;
	}
}
