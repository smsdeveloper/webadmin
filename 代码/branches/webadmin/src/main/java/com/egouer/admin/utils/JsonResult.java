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
	
	private long total;
	private String result;
	private String code;
	private String msg;
	private Object rows;
	
	public JsonResult(String result,String msg,String code,Object rows,long count)
	{
		this.result = result;
		this.msg = msg;
		this.code = code;
		this.rows = rows;
		this.total = count;
	}
	
	public JsonResult(String result,String msg,Object rows,long count)
	{
		this.result = result;
		this.msg = msg;
		this.rows = rows;
		this.total = count;
	}
	
	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
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

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}
	
}
