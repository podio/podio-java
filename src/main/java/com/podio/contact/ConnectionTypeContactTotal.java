package com.podio.contact;

import java.util.List;

import com.podio.connection.ConnectionType;

public class ConnectionTypeContactTotal {

	private ConnectionType type;

	private int count;

	private List<ConnectionContactTotal> connections;

	public ConnectionType getType() {
		return type;
	}

	public void setType(ConnectionType type) {
		this.type = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<ConnectionContactTotal> getConnections() {
		return connections;
	}

	public void setConnections(List<ConnectionContactTotal> connections) {
		this.connections = connections;
	}
}
