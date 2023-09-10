package org.come.bean;

import org.come.entity.Goodstable;
import org.come.entity.Lingbao;
import org.come.entity.RoleSummoning;
import org.come.entity.Salegoods;


/**
 * 商品详情bean
 * @author Administrator
 *
 */
public class GoodsDetailsBean {
	
	//商品详细详情
	private Goodstable goodstable;
	
	// 召唤兽
	private RoleSummoning roleSummoning;
	
	// 灵宝
	private Lingbao lingbao;
	
	//商品销售上架详情
	private  Salegoods salegoods;

	public Goodstable getGoodstable() {
		return this.goodstable;
	}

	public void setGoodstable(Goodstable goodstable) {
		this.goodstable = goodstable;
	}

	public Salegoods getSalegoods() {
		return this.salegoods;
	}

	public void setSalegoods(Salegoods salegoods) {
		this.salegoods = salegoods;
	}

	public RoleSummoning getRoleSummoning() {
		return this.roleSummoning;
	}

	public void setRoleSummoning(RoleSummoning roleSummoning) {
		this.roleSummoning = roleSummoning;
	}

	public Lingbao getLingbao() {
		return this.lingbao;
	}

	public void setLingbao(Lingbao lingbao) {
		this.lingbao = lingbao;
	}

}
