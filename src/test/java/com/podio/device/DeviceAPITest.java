package com.podio.device;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.podio.APIFactoryProvider;

public class DeviceAPITest {

	private DeviceAPI getAPI() {
		return APIFactoryProvider.getDefault().getAPI(DeviceAPI.class);
	}
}
