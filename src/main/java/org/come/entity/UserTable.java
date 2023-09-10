package org.come.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 用户bean
 * @author 叶豪芳
 * @date : 2017年11月27日 上午10:08:18
 */
public class UserTable {
	private BigDecimal user_id;

	private String username;

	private String userpwd;

	// 用户状态（0 正常）
	private Short activity;

	private Long vip;//

	private BigDecimal frient_id;//

	private String safety;

	private Long idcard;

	private BigDecimal codecard;

	private Integer money;
	//quID
	private BigDecimal qid;

	private Double usermoney;
	//    /**注册时间*/
//    private Date logonTime;
//    /**离线时间*/
//    private Date lineTime;
	//开始页码
	private int start;
	//结束页码
	private int end;
	private  Integer payintegration = null;//充值叠加积分，统计使用
	private  String Userregidtsertime;//账号注册时间
	private  String USERLASTLOGIN;//账号最后登陆时间（记录最后下线的时间）

	// zeng-190711 --
	// 登录ip
	private String loginip;
	// 注册ip
	private String registerip;
	// --

	/** HGC--2019-11-13 */
	/** 绑定的手机号 */
	private String phonenumber;
	/** 手机号码异动时间 */
	private String phonetime;

	/**
	 * 外界调用存储，没有实际意义
	 * @return
	 */
	private String useString;
	// 推荐码
	private String tuiji;
	// 账号绑定信息
	private String flag;

	public static void main(String[] args) {
		try {
//			30 Aug 2019 14:54:07 GMT
//			6389:94451W
			System.out.println(new Date(1567177597619L));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public String getLoginip() {
		return this.loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	public String getRegisterip() {
		return this.registerip;
	}

	public void setRegisterip(String registerip) {
		this.registerip = registerip;
	}

	public String getUseString() {
		return this.useString;
	}

	public void setUseString(String useString) {
		this.useString = useString;
	}

	public int getStart() {
		return this.start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return this.end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public Double getUsermoney() {
		return this.usermoney;
	}

	public void setUsermoney(Double usermoney) {
		this.usermoney = usermoney;
	}

	public BigDecimal getQid() {
		return this.qid;
	}

	public void setQid(BigDecimal qid) {
		this.qid = qid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getUserpwd() {
		return this.userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd == null ? null : userpwd.trim();
	}

	public Short getActivity() {
		return this.activity;
	}

	public void setActivity(Short activity) {
		this.activity = activity;
	}

	public Long getVip() {
		return this.vip;
	}

	public void setVip(Long vip) {
		this.vip = vip;
	}


	public BigDecimal getUser_id() {
		return this.user_id;
	}

	public void setUser_id(BigDecimal user_id) {
		this.user_id = user_id;
	}

	public BigDecimal getFrient_id() {
		return this.frient_id;
	}

	public void setFrient_id(BigDecimal frient_id) {
		this.frient_id = frient_id;
	}

	public String getSafety() {
		return this.safety;
	}

	public void setSafety(String safety) {
		this.safety = safety == null ? null : safety.trim();
	}

	public Long getIdcard() {
		return this.idcard;
	}

	public void setIdcard(Long idcard) {
		this.idcard = idcard;
	}

	public BigDecimal getCodecard() {
		return this.codecard;
	}

	public void setCodecard(BigDecimal codecard) {
		this.codecard = codecard;
	}

	public Integer getMoney() {
		return this.money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Integer getPayintegration() {
		if (this.payintegration==null) {
			this.payintegration=0;
		}
		return this.payintegration;
	}

	public void setPayintegration(Integer payintegration) {
		this.payintegration = payintegration;
	}

	public String getUserregidtsertime() {
		return this.Userregidtsertime;
	}

	public void setUserregidtsertime(String userregidtsertime) {
		this.Userregidtsertime = userregidtsertime;
	}

	public String getUSERLASTLOGIN() {
		return this.USERLASTLOGIN;
	}

	public void setUSERLASTLOGIN(String uSERLASTLOGIN) {
		this.USERLASTLOGIN = uSERLASTLOGIN;
	}


	public String getPhonenumber() {
		return this.phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getPhonetime() {
		return this.phonetime;
	}


	public void setPhonetime(String phonetime) {
		this.phonetime = phonetime;
	}

	public String getTuiji() {
		return this.tuiji;
	}


	public void setTuiji(String tuiji) {
		this.tuiji = tuiji;
	}
	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "UserTable [user_id=" + this.user_id + ", username=" + this.username + ", userpwd=" + this.userpwd + ", activity=" + this.activity + ", vip=" + this.vip + ", frient_id=" + this.frient_id + ", safety=" + this.safety
				+ ", idcard=" + this.idcard + ", codecard=" + this.codecard + ", money=" + this.money + ", qid=" + this.qid + ", usermoney=" + this.usermoney + ", start=" + this.start + ", end=" + this.end + ", payintegration="
				+ this.payintegration + ", Userregidtsertime=" + this.Userregidtsertime + ", USERLASTLOGIN=" + this.USERLASTLOGIN + ", loginip=" + this.loginip + ", registerip=" + this.registerip + ", phonenumber="
				+ this.phonenumber + ", phonetime=" + this.phonetime + ", useString=" + this.useString + "]";
	}



}