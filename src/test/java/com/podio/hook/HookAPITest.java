package com.podio.hook;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.podio.APIFactoryProvider;
import com.podio.common.Reference;
import com.podio.common.ReferenceType;

public class HookAPITest {

	private HookAPI getAPI() {
		return APIFactoryProvider.getDefault().getAPI(HookAPI.class);
	}

	@Test
	public void create() {
		int id = getAPI().create(new Reference(ReferenceType.APP, 1),
				new HookCreate("http://foobar.com/test", HookType.ITEM_CREATE));
		Assert.assertTrue(id > 1);
	}

	@Test
	public void delete() {
		getAPI().delete(1);
	}

	@Test
	public void requestVerification() {
		getAPI().requestVerification(2);
	}

	@Test
	public void validateVerification() {
		getAPI().validateVerification(2, "b9079247");
	}

	@Test
	public void get() {
		List<Hook> hooks = getAPI().get(new Reference(ReferenceType.APP, 1));

		Assert.assertEquals(hooks.size(), 9);
		Assert.assertEquals(hooks.get(0).getId(), 1);
		Assert.assertEquals(hooks.get(0).getUrl(), "http://foobar.com/nowhere");
		Assert.assertEquals(hooks.get(0).getStatus(), HookStatus.ACTIVE);
		Assert.assertEquals(hooks.get(0).getType(), HookType.ITEM_CREATE);
	}
}
