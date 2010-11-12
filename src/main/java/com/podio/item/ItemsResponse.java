package com.podio.item;

import java.util.List;

public class ItemsResponse {

	/**
	 * Total number of items
	 */
	private int total;

	/**
	 * Total number of items matching the filter
	 */
	private int filtered;

	/**
	 * The items returned
	 */
	private List<ItemBadge> items;

	@Override
	public String toString() {
		return "ItemsResponse [total=" + total + ", filtered=" + filtered
				+ ", items=" + items + "]";
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getFiltered() {
		return filtered;
	}

	public void setFiltered(int filtered) {
		this.filtered = filtered;
	}

	public List<ItemBadge> getItems() {
		return items;
	}

	public void setItems(List<ItemBadge> items) {
		this.items = items;
	}
}
