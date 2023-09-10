package org.come.extInterBean;

import java.util.List;

public class GodsRecordResultModel {

	private List<Goodsrecord2> godsRec;
	private int Page;
	private int PageSum;

	public GodsRecordResultModel() {
		// TODO Auto-generated constructor stub
	}

	public GodsRecordResultModel(List<Goodsrecord2> godsRec, int page, int pageSum) {
		super();
		this.godsRec = godsRec;
		this.Page = page;
		this.PageSum = pageSum;
	}

	public List<Goodsrecord2> getGodsRec() {
		return this.godsRec;
	}

	public void setGodsRec(List<Goodsrecord2> godsRec) {
		this.godsRec = godsRec;
	}

	public int getPage() {
		return this.Page;
	}

	public void setPage(int page) {
		this.Page = page;
	}

	public int getPageSum() {
		return this.PageSum;
	}

	public void setPageSum(int pageSum) {
		this.PageSum = pageSum;
	}

}
