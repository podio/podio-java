package com.podio.item.map;

import org.apache.commons.beanutils.ConvertUtils;

import com.podio.APIFactory;
import com.podio.app.AppAPI;
import com.podio.app.Application;
import com.podio.item.ItemAPI;
import com.podio.item.ItemsResponse;

public class MappedItemAPI<T> {

	private final APIFactory factory;

	private final Application application;

	private final ItemMap<T> map;

	public MappedItemAPI(APIFactory factory, int appId, Class<T> cls) {
		super();
		this.factory = factory;
		this.application = factory.getAPI(AppAPI.class).getApp(appId);
		this.map = ItemMap.get(application, cls);
	}

	public int insert(T object, boolean silent) {
		return factory.getAPI(ItemAPI.class).addItem(application.getId(),
				map.getCreate(object), silent);
	}

	public void update(T object, boolean silent) {
		factory.getAPI(ItemAPI.class).updateItem(-1, map.getUpdate(object),
				silent, false);
	}

	public T get(Object externalId) {
		String stringExternalId = (String) ConvertUtils.convert(externalId,
				String.class);

		ItemsResponse item = factory.getAPI(ItemAPI.class)
				.getItemsByExternalId(application.getId(), stringExternalId);
		if (item.getFiltered() == 1) {
			return map.getView(item.getItems().get(0));
		} else if (item.getFiltered() == 0) {
			return null;
		} else {
			throw new RuntimeException(
					"Multiple items found with the external id " + externalId);
		}
	}
}
