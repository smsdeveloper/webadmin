package com.egouer.admin.base;

public class BaseObj {

	private int pagesize = 10;
	private int offset = 0;
	private int pageno = 1;
	private long pagecount = 0;
	private long datacount = 0;
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	public long getPagecount() {
		return pagecount;
	}
	public void setPagecount(long pagecount) {
		this.pagecount = pagecount;
	}
	public long getDatacount() {
		return datacount;
	}
	public void setDatacount(long datacount) {
		this.datacount = datacount;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
}
