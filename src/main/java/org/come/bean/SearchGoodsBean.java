package org.come.bean;
/**
 * 商品搜索bean
 * @author Administrator
 *
 */
public class SearchGoodsBean {
    /**
     * 类型
     */
    private Integer saletype;
    
    /**
     * 条件分类
     */
    private String contiontype;
    
    /**
     * 商品名称
     */
    private String salename;
    
    /**
     * 页数
     */
    private Integer pageNum;
    
    /**
     * 是否显示公示期标识 0 不显示  1显示  2只显示公示期
     */
    private int show;
    
    /**
     * 价格排序字段  0 默认排序  1 升序   2 降序
     */
    private int order;

	public Integer getSaletype() {
		return this.saletype;
	}

	public void setSaletype(Integer saletype) {
		this.saletype = saletype;
	}


	public String getContiontype() {
		return this.contiontype;
	}

	public void setContiontype(String contiontype) {
		this.contiontype = contiontype;
	}

	public String getSalename() {
		return this.salename;
	}

	public void setSalename(String salename) {
		this.salename = salename;
	}

	public Integer getPageNum() {
		return this.pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public int getShow() {
		return this.show;
	}

	public void setShow(int show) {
		this.show = show;
	}

	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
    
}
