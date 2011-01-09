package com.podio.item.map;

import org.junit.Assert;
import org.junit.Test;

public class NameUtilTest {

	@Test
	public void toJava() {
		Assert.assertEquals(NameUtil.toJava("is-hired"), "isHired");
		Assert.assertEquals(NameUtil.toJava("hired"), "hired");
		Assert.assertEquals(NameUtil.toJava("is-hired-ok"), "isHiredOk");
	}

	@Test
	public void toAPI() {
		Assert.assertEquals(NameUtil.toAPI("isHired"), "is-hired");
		Assert.assertEquals(NameUtil.toAPI("hired"), "hired");
		Assert.assertEquals(NameUtil.toAPI("isHiredOk"), "is-hired-ok");
	}
}
