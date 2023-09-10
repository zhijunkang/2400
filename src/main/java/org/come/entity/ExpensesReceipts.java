package org.come.entity;

import java.math.BigDecimal;

public class ExpensesReceipts {
	/**
	 * 收支ID(订单号)
	 */
	private BigDecimal erid;

	/**
	 * 玩家账号
	 */
	private String playeracc;
	//支付类型 1仙玉充值 2周月卡充值 3小资冲级礼包充值 4土豪冲级礼包字段
	private int type;
	//角色id
	private BigDecimal roleid;
	/**
	 * 充值金额
	 */
	private BigDecimal recharge;

	/**
	 * 玩家获取金额
	 */
	private BigDecimal playerpay;

	/**
	 * 获得元宝
	 */
	private BigDecimal yuanbao;

	/**
	 * 充值时间
	 */
	private String paytime;

	/**
	 * 服务区ID
	 */
	private BigDecimal sid;

	/**
	 * 支付的状态，默认0表示回调失败
	 */
	private BigDecimal returntype;

	/**
	 * 收款的商户ID
	 */
	private BigDecimal appid;

	/**
	 * 管理员Id,负责管理的
	 */
	private BigDecimal managerid;

	/**
	 * 开始编号
	 */

	private Integer start;

	/**
	 * 结束编号
	 */

	private Integer end;

	/**
	 * 判断查询订单编号是否存在
	 * 
	 * @return
	 */

	private int ordernumbertype = 0;

	// 商品id
	private BigDecimal goodsid;
	// 买家角色id
	private BigDecimal buyrole;
	// 卖家角色id
	private BigDecimal sellrole;
	// 买家账号id
	private BigDecimal buyuserid;
	// 买家余额
	private String buyrolebalance;
	// 公示期标志(1、公示期 2、正常)
	private String gongshisign;
	// 区id
	private String quid;
	// 支付利润
	private Double payofprofits;
	// 公示期利润
	private Double gspayofprofits;

	// 买家角色名
	private String buyroleName;
	// 卖家角色名
	private String sellroleName;
	// 买家账号
	private String buyuseridName;

	private String quname;

	// 商品信息
	private String goodssomething;

	/**
     * 页码
     */
    private int pageNumber=1;
	public String getGoodssomething() {
		return this.goodssomething;
	}

	public void setGoodssomething(String goodssomething) {
		this.goodssomething = goodssomething;
	}

	public Integer getStart() {
		return this.start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return this.end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public int getOrdernumbertype() {
		return this.ordernumbertype;
	}

	public void setOrdernumbertype(int ordernumbertype) {
		this.ordernumbertype = ordernumbertype;
	}

	/**
	 * 收支ID(订单号)
	 * 
	 * @return ERID 收支ID(订单号)
	 */
	public BigDecimal getErid() {

		return this.erid;
	}

	/**
	 * 收支ID(订单号)
	 * 
	 * @param erid
	 *            收支ID(订单号)
	 */
	public void setErid(BigDecimal erid) {
		this.erid = erid;
	}

	/**
	 * 玩家账号
	 * 
	 * @return PLAYERACC 玩家账号
	 */
	public String getPlayeracc() {
		return this.playeracc;
	}

	/**
	 * 玩家账号
	 * 
	 * @param playeracc
	 *            玩家账号
	 */
	public void setPlayeracc(String playeracc) {
		this.playeracc = playeracc == null ? null : playeracc.trim();
	}

	/**
	 * 充值金额
	 * 
	 * @return RECHARGE 充值金额
	 */
	public BigDecimal getRecharge() {
		return this.recharge;
	}

	/**
	 * 充值金额
	 * 
	 * @param recharge
	 *            充值金额
	 */
	public void setRecharge(BigDecimal recharge) {
		this.recharge = recharge;
	}

	/**
	 * 玩家获取金额
	 * 
	 * @return PLAYERPAY 玩家获取金额
	 */
	public BigDecimal getPlayerpay() {
		return this.playerpay;
	}

	/**
	 * 玩家获取金额
	 * 
	 * @param playerpay
	 *            玩家获取金额
	 */
	public void setPlayerpay(BigDecimal playerpay) {
		this.playerpay = playerpay;
	}

	/**
	 * 获得元宝
	 * 
	 * @return YUANBAO 获得元宝
	 */
	public BigDecimal getYuanbao() {
		return this.yuanbao;
	}

	/**
	 * 获得元宝
	 * 
	 * @param yuanbao
	 *            获得元宝
	 */
	public void setYuanbao(BigDecimal yuanbao) {
		this.yuanbao = yuanbao;
	}

	/**
	 * 充值时间
	 * 
	 * @return PAYTIME 充值时间
	 */
	public String getPaytime() {
		return this.paytime;
	}

	/**
	 * 充值时间
	 * 
	 * @param paytime
	 *            充值时间
	 */
	public void setPaytime(String paytime) {
		this.paytime = paytime == null ? null : paytime.trim();
	}

	/**
	 * 服务区ID
	 * 
	 * @return SID 服务区ID
	 */
	public BigDecimal getSid() {
		return this.sid;
	}

	/**
	 * 服务区ID
	 * 
	 * @param sid
	 *            服务区ID
	 */
	public void setSid(BigDecimal sid) {
		this.sid = sid;
	}

	/**
	 * 支付的状态，默认0表示回调失败
	 * 
	 * @return RETURNTYPE 支付的状态，默认0表示回调失败
	 */
	public BigDecimal getReturntype() {
		return this.returntype;
	}

	/**
	 * 支付的状态，默认0表示回调失败
	 * 
	 * @param returntype
	 *            支付的状态，默认0表示回调失败
	 */
	public void setReturntype(BigDecimal returntype) {
		this.returntype = returntype;
	}

	/**
	 * 收款的商户ID
	 * 
	 * @return APPID 收款的商户ID
	 */
	public BigDecimal getAppid() {
		return this.appid;
	}

	/**
	 * 收款的商户ID
	 * 
	 * @param appid
	 *            收款的商户ID
	 */
	public void setAppid(BigDecimal appid) {
		this.appid = appid;
	}

	/**
	 * 管理员Id,负责管理的
	 * 
	 * @return MANAGERID 管理员Id,负责管理的
	 */
	public BigDecimal getManagerid() {
		return this.managerid;
	}

	/**
	 * 管理员Id,负责管理的
	 * 
	 * @param managerid
	 *            管理员Id,负责管理的
	 */
	public void setManagerid(BigDecimal managerid) {
		this.managerid = managerid;
	}

	public BigDecimal getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(BigDecimal goodsid) {
		this.goodsid = goodsid;
	}

	public BigDecimal getBuyrole() {
		return this.buyrole;
	}

	public void setBuyrole(BigDecimal buyrole) {
		this.buyrole = buyrole;
	}

	public BigDecimal getSellrole() {
		return this.sellrole;
	}

	public void setSellrole(BigDecimal sellrole) {
		this.sellrole = sellrole;
	}

	public BigDecimal getBuyuserid() {
		return this.buyuserid;
	}

	public void setBuyuserid(BigDecimal buyuserid) {
		this.buyuserid = buyuserid;
	}

	public String getBuyrolebalance() {
		return this.buyrolebalance;
	}

	public void setBuyrolebalance(String buyrolebalance) {
		this.buyrolebalance = buyrolebalance;
	}

	public String getGongshisign() {
		return this.gongshisign;
	}

	public void setGongshisign(String gongshisign) {
		this.gongshisign = gongshisign;
	}

	public String getQuid() {
		return this.quid;
	}

	public void setQuid(String quid) {
		this.quid = quid;
	}

	public String getBuyroleName() {
		return this.buyroleName;
	}

	public void setBuyroleName(String buyroleName) {
		this.buyroleName = buyroleName;
	}

	public String getSellroleName() {
		return this.sellroleName;
	}

	public void setSellroleName(String sellroleName) {
		this.sellroleName = sellroleName;
	}

	public String getBuyuseridName() {
		return this.buyuseridName;
	}

	public void setBuyuseridName(String buyuseridName) {
		this.buyuseridName = buyuseridName;
	}

	public Double getPayofprofits() {
		return this.payofprofits;
	}

	public void setPayofprofits(Double payofprofits) {
		this.payofprofits = payofprofits;
	}

	public Double getGspayofprofits() {
		return this.gspayofprofits;
	}

	public void setGspayofprofits(Double gspayofprofits) {
		this.gspayofprofits = gspayofprofits;
	}

	public String getQuname() {
		return this.quname;
	}

	public void setQuname(String quname) {
		this.quname = quname;
	}

	public int getPageNumber() {
		return this.pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}
	public BigDecimal getRoleid() {
		return this.roleid;
	}
	public void setRoleid(BigDecimal roleid) {
		this.roleid = roleid;
	}
}