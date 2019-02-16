package com.fangjia.mqclient.common;


import java.util.Collections;
import java.util.List;

/** 分页查询值对象
 */
public class PageBean<E> {
	
	private int start;//起始记录数
	
	private int limit;//最大记录数
	
	private long totalRecords;//总记录数
	
	private int currentPage;//当前页
	
	private int totalPages;//总页数
	
	private List<E> list;//查询数据对象

	public static int page2Start(int page, int limit){
		return page * limit - limit;
	}

	public static int start2Page(int start, int limit){
		if(limit == 0) return 0;
		return (int)(start + limit) / limit;
	}
	
	public static int calcPages(long totalRecords, int limit) {
		return (int) totalRecords / limit 
				+ (totalRecords % limit > 0 ? 1 : 0);
	}
	
	public PageBean(){
		
	}
	
	public PageBean(int start, int limit){
		this.start = start;
		this.limit = limit;
		this.currentPage = start2Page(start, limit);
	}
	
	public PageBean(int start, int limit, List<E> list, long totalRecords){
		this.start = start;
		this.limit = limit;
		this.list = list;
		this.totalRecords = totalRecords;
		this.currentPage = start2Page(start, limit);
		if (this.limit == 0) {
			this.totalPages = 0;
		} else {
			this.totalPages = (int) this.totalRecords / this.limit 
					+ (this.totalRecords % this.limit > 0 ? 1 : 0);
		}
	
	}
	
	public long getStart() {
		return start;
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	
	public int getLimit() {
		return limit;
	}
	
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public long getTotalRecords() {
		return totalRecords;
	}
	
	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	public void setList(List<E> list) {
		this.list = list;
	}
	
	@SuppressWarnings("unchecked")
	public List<E> getList() {
		if(list == null){
			return Collections.EMPTY_LIST;
		}
		return Collections.unmodifiableList(list);
	}
	
}
