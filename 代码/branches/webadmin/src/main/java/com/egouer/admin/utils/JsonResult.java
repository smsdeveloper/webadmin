package com.egouer.admin.utils;

public class JsonResult {

	public enum Result{
		
		RESULT_SUCCESS("success","请求成功"),
		RESULT_ERROR("error","请求失败"),
		RESULT_EXCEPTION("exception","请求异常");
		
		private String result;
		private String msg;
		Result(String result,String msg)
		{
			this.result = result;
			this.msg = msg;
		}
		public String getResult() {
			return result;
		}
		public void setResult(String result) {
			this.result = result;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
	}
	
	private long count;
	private String result;
	private String code;
	private String msg;
	private Object data;
	
	public JsonResult(String result,String msg,String code,Object data,long count)
	{
		this.result = result;
		this.msg = msg;
		this.code = code;
		this.data = data;
		this.count = count;
	}
	
	public JsonResult(String result,String msg,Object data,long count)
	{
		this.result = result;
		this.msg = msg;
		this.data = data;
		this.count = count;
	}
	
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
