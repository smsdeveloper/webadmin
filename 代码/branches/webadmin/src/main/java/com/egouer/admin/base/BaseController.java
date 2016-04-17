package com.egouer.admin.base;

import org.springframework.web.servlet.ModelAndView;

public class BaseController {

	protected static final String ERROR_MSG = "error_msg";
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public ModelAndView toView()
	{
		return new ModelAndView(this.getPath());
	}
	
	
}
