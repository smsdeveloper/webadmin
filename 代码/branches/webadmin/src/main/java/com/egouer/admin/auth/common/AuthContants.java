package com.egouer.admin.auth.common;

import com.egouer.admin.utils.ReadProperties;

public class AuthContants {

	private static final String PROPERTIES_NAME = "config/application.properties";
	public static final String COOKIE_DOMAIN = ReadProperties.loadProp(PROPERTIES_NAME).getProperty("cookie.domain");
}
