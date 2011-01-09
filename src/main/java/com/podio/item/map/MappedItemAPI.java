package com.podio.item.map;

import org.apache.commons.beanutils.ConvertUtils;

import com.podio.APIFactory;
import com.podio.app.Application;
import com.podio.item.ItemsResponse;

public class MappedItemAPI<T> {

	private final APIFactory factory;

	private final Application application;

	private final ItemMap<T> map;

	public MappedItemAPI(APIFactory factory, int appId, Class<T> cls) {
		super();
		this.factory = factory;
		this.application = factory.getAppAPI().getApp(appId);
		this.map = ItemMap.get(application, cls);
	}

	public int insert(T object, boolean silent) {
		return factory.getItemAPI().addItem(application.getId(),
				map.getCreate(object), silent);
	}

	public void update(T object, boolean silent) {
		// FIXME: Decide if we want to add item id to the model, use external
		// id, or keep it separate
		factory.getItemAPI().updateItem(-1, map.getUpdate(object), silent);
	}

	public T get(Object externalId) {
		String stringExternalId = (String) ConvertUtils.convert(externalId,
				String.class);

		ItemsResponse item = factory.getItemAPI().getItemsByExternalId(
				application.getId(), stringExternalId);
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
