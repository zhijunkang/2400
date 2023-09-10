package org.come.model;

import come.tool.Calculation.BaseQl;

/**
 * 称谓
 * @author Administrator
 *
 */
public class Title {
	// id
	private Integer id;
	// 称谓名称
	private String titlename;
	// 条件
	private String exist;
    //描述
	private String text;
	//属性
	private String value;
	//特效皮肤
	private String skin;
	
	private transient BaseQl[] qls;
	
	public BaseQl[] getQls() {
		if (this.qls==null) {
			if (this.value!=null&&!this.value.equals("")) {
				String[] vs=this.value.split("\\|");
				this.qls=new BaseQl[vs.length];
				for (int i = 0; i < vs.length; i++) {
					String[] vss=vs[i].split("=");
					this.qls[i]=new BaseQl(vss[0], Double.parseDouble(vss[1]));
				}
			}
		}
		return this.qls;
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitlename() {
		return this.titlename;
	}

	public void setTitlename(String titlename) {
		this.titlename = titlename;
	}

	public String getExist() {
		return this.exist;
	}

	public void setExist(String exist) {
		this.exist = exist;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSkin() {
		return this.skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}
	
	
}
