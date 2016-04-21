package com.egouer.admin.base;

import org.springframework.web.servlet.ModelAndView;

import com.egouer.admin.utils.JsonResult;

public class BaseController {

	protected static final String ERROR_MSG = "error_msg";
	private JsonResult jsonResult;
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
	
	public void setJsonResult(String result,String msg,String code,Object data,int count)
	{
		this.jsonResult = new JsonResult(result,msg,code,data,count);
	}
	
	public JsonResult getJsonResult()
	{
		return this.jsonResult;
	}
}
