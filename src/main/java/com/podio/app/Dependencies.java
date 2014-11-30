package com.podio.app;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Dependencies implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Application> apps;

	private Map<Integer, List<Integer>> dependencies;

	public List<Application> getApps() {
		return apps;
	}

	public void setApps(List<Application> apps) {
		this.apps = apps;
	}

	public Map<Integer, List<Integer>> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Map<Integer, List<Integer>> dependencies) {
		this.dependencies = dependencies;
	}
}
