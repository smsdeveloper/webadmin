package com.egouer.admin.auth.common;

public enum FunctionEnum {
	STATUS_OK("正常"),
	STATUS_CLOSE("停用"),
	TYPE_PRIV("权限");
	private String param;
	FunctionEnum(String param)
	{
		this.param = param;
	}
	public String getParam() {
		return param;
	}

}
