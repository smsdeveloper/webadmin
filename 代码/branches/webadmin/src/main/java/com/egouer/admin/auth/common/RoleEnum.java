package com.egouer.admin.auth.common;

public enum RoleEnum {
	STATUS_OK("正常"),
	STATUS_CLOSE("停用");
	private String param;
	RoleEnum(String param)
	{
		this.param = param;
	}
	public String getParam() {
		return param;
	}
}
