package org.come.model;
/**
 * GMshop
 *
 * @author mist
 * @date : 2022年02月16日 下午3:21:29
 */
public class GMshopItem {
	//id
	private String shopId;
	//id
	private String itemId;
	// 名称
	private String shopName;
	// 类型 (1普通2豪华3尊享)
	private String shoptype;
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShoptype() {
		return shoptype;
	}
	public void setShoptype(String shoptype) {
		this.shoptype = shoptype;
	}
}
