package com.egouer.admin.auth.vo;

import java.util.List;

import com.egouer.admin.auth.domain.Function;
import com.egouer.admin.auth.domain.User;

public class SessionBean {

	private User user;
	private String loginTime;
	private String ip;
	private List<Function> functions;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public List<Function> getFunctions() {
		return functions;
	}
	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}
	
}
