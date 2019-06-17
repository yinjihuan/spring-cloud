package com.fangjia.common.base;

public class PageQueryParam {
	private int page;
	private int start;
	private int limit;
	private String sort;
	private boolean asc;
	
	public PageQueryParam() {
		
	}
	
	public PageQueryParam(int page, int limit) {
		setLimit(limit);
		setPage(page);
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
		if(limit > 0){
			this.start = PageBean.page2Start(page, limit);
		}
	}
	
	public int getStart() {
		if (start < 0) {
			return 0;
		}
		return start;
	}
	
	public void setStart(int start) {
		this.start = start;
		if(limit > 0){
			this.page = PageBean.start2Page(start, limit);
		}
	}
	
	public int getLimit() {
		return limit;
	}
	
	public void setLimit(int limit) {
		this.limit = limit;
		if(page > 0){
			this.start = PageBean.page2Start(page, limit);
		}
		if(start > 0){
			this.page = PageBean.start2Page(start, limit);
		}
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public boolean isAsc() {
		return asc;
	}
	public void setAsc(boolean asc) {
		this.asc = asc;
	}
	
}
