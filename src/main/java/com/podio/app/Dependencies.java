package com.podio.app;

import java.util.List;
import java.util.Map;

public class Dependencies {

	private List<ApplicationMicro> apps;

	private Map<Integer, List<Integer>> dependencies;

	public List<ApplicationMicro> getApps() {
		return apps;
	}

	public void setApps(List<ApplicationMicro> apps) {
		this.apps = apps;
	}

	public Map<Integer, List<Integer>> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Map<Integer, List<Integer>> dependencies) {
		this.dependencies = dependencies;
	}
}
