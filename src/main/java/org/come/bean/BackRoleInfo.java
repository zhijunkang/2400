package org.come.bean;

import java.util.List;

import org.come.entity.RoleTable;

public class BackRoleInfo {
	
	private List<RoleTable> list;
	
	private int pageNum;
	private long total;
	private int pages;
	public long getTotal() {
		return this.total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<RoleTable> getList() {
		return this.list;
	}
	public void setList(List<RoleTable> list) {
		this.list = list;
	}
	public int getPageNum() {
		return this.pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPages() {
		return this.pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}

}
