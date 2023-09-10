package org.come.entity;

import java.util.List;

/**
 * 查询背包返回的对象列表
 * 
 * @author Administrator
 * 
 */

public class SearchGoodstableList {

	private int sumpage;// 总页码

	private List<GoodsRoleUser> listGoodsTable;

	public int getSumpage() {
		return this.sumpage;
	}

	public void setSumpage(int sumpage) {
		this.sumpage = sumpage;
	}

	public List<GoodsRoleUser> getListGoodsTable() {
		return this.listGoodsTable;
	}

	public void setListGoodsTable(List<GoodsRoleUser> listGoodsTable) {
		this.listGoodsTable = listGoodsTable;
	}

}
