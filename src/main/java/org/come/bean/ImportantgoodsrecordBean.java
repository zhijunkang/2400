package org.come.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * HGC--2019-11-18 重要物资汇总 bean
 * 
 * @author Administrator
 * 
 */
public class ImportantgoodsrecordBean {
	private String goodsid;// 物品 id
	private String name;// 物品名称
	private List<String> recorddate;// 记录数据 (按 照时间记录 1-7)
	private List<String> time;// 记录数据 (按 照时间记录 1-7)
	private int page;// 查询页码
	
	public ImportantgoodsrecordBean() {
		super();
	}

	public ImportantgoodsrecordBean(String goodsid, String name, String recorddate, String time, int page) {
		super();
		this.goodsid = goodsid;
		this.name = name;
		getRecorddate().add(recorddate);
		getTime().add(time);
	}

	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getRecorddate() {
		if(this.recorddate == null){
			this.recorddate = new ArrayList<>();
		}
		return this.recorddate;
	}

	public void setRecorddate(List<String> recorddate) {
		this.recorddate = recorddate;
	}

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<String> getTime() {
		if(this.time == null){
			this.time = new ArrayList<>();
		}
		return this.time;
	}

	public void setTime(List<String> time) {
		this.time = time;
	}

}
