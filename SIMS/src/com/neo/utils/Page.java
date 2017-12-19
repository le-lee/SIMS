package com.neo.utils;

public class Page {
	public final static int DEFAUL_PAGE_SIZE = 5;
	/**当前页*/
	private int pageNo;
	/**每页大小*/
	private int pageSize;
	private int totalPageNo;
	private int totalRecord;
	
	
	private int startIndex;
	private int firstPageStartIndex;
	private int finalPageStartIndex;
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalPageNo() {
		return totalPageNo;
	}
	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getFirstPageStartIndex() {
		return firstPageStartIndex;
	}
	public void setFirstPageStartIndex(int firstPageStartIndex) {
		this.firstPageStartIndex = firstPageStartIndex;
	}
	public int getFinalPageStartIndex() {
		return finalPageStartIndex;
	}
	public void setFinalPageStartIndex(int finalPageStartIndex) {
		this.finalPageStartIndex = finalPageStartIndex;
	}
	
}
