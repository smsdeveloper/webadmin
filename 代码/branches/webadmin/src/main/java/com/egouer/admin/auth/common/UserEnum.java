package com.egouer.admin.auth.common;

public enum UserEnum {

	STATUS_OK("正常");
	
	private String status;
	UserEnum(String status)
	{
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	
	
}
