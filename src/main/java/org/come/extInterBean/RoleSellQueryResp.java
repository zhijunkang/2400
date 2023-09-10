package org.come.extInterBean;

import java.util.List;

import org.come.bean.SearchGoodsResultBean;
import org.come.entity.Salegoods;

import come.tool.Role.CBGData;

/**
 * 角色售卖
 * 
 * @author zengr
 * 
 */
public class RoleSellQueryResp {

	// 类型
	private String type;
	// 角色信息
	private List<RoleSellRoleInfo> roleInfo;
	// 角色购买订单查询
	private SearchGoodsResultBean searchGoods;
	//
	private Salegoods salegoods;
	// 藏宝阁信息
	private CBGData cbgData;

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<RoleSellRoleInfo> getRoleInfo() {
		return this.roleInfo;
	}

	public void setRoleInfo(List<RoleSellRoleInfo> roleInfo) {
		this.roleInfo = roleInfo;
	}

	public SearchGoodsResultBean getSearchGoods() {
		return this.searchGoods;
	}

	public void setSearchGoods(SearchGoodsResultBean searchGoods) {
		this.searchGoods = searchGoods;
	}

	public CBGData getCbgData() {
		return this.cbgData;
	}

	public void setCbgData(CBGData cbgData) {
		this.cbgData = cbgData;
	}

	public Salegoods getSalegoods() {
		return this.salegoods;
	}

	public void setSalegoods(Salegoods salegoods) {
		this.salegoods = salegoods;
	}

}
