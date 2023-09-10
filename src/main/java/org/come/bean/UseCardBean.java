package org.come.bean;

import come.tool.Calculation.BaseQl;

public class UseCardBean {

	private String lCard;
	private String name ;
	private String type ;
	private String skin ;
	private String value;
	private long   time;//0无期限  -1是删除这个类型

	private transient BaseQl[] qls;
	
	public UseCardBean() {
		// TODO Auto-generated constructor stub
	}
	public UseCardBean(String name, String type, String skin, long time, String value) {
		super();
		this.name = name;
		this.type = type;
		this.skin = skin;
		this.time = time;
		this.value= value;
	}
	public String getlCard() {
		return this.lCard;
	}
	public void setlCard(String lCard) {
		this.lCard = lCard;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSkin() {
		return this.skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	public long getTime() {
		return this.time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getValue() {
		if (this.value==null) {return "";}
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
		this.qls   = null;
	}
	//单挑属性加入或者修改
	public void upValue(String msg,int wei) {
		
		int path=msg.indexOf("=");
		String key=msg.substring(0, path);
		double value=Double.parseDouble(msg.substring(path+1));
		if (this.value==null||this.value.equals("")) {
			setValue(key+"="+((value!=(int)value)?value:(int)value));
			return;
		}
		BaseQl baseQl=(this.qls==null||this.qls.length>=wei)?null:this.qls[wei];
		StringBuffer buffer=new StringBuffer();
		if (baseQl!=null) {
			baseQl.setKey(key);
			baseQl.setValue(value);	
			for (int i = 0; i < this.qls.length; i++) {
				BaseQl base=this.qls[i];
				if (buffer.length()!=0) {buffer.append("|");}
				buffer.append(base.getKey());
				buffer.append("=");
				buffer.append((base.getValue()!=(int)base.getValue())?base.getValue():(int)base.getValue());
			}	
			this.value=buffer.toString();
			return;
		}
		String[] vs=this.value.split("\\|");
		String mm=key+"="+((value!=(int)value)?value:(int)value);
		for (int i = 0; i < vs.length; i++) {
			if (buffer.length()!=0) {buffer.append("|");}
			if (i!=wei) {
				buffer.append(vs[i]);
			}else {
				buffer.append(mm);
				mm=null;
			}
		}
		if (mm!=null) {
			if (buffer.length()!=0) {buffer.append("|");}
			buffer.append(mm);
		}
		setValue(buffer.toString());
	}
	public Double getQlKey(String key) {
		getQls();
		if (this.qls==null) {return null;}
		for (int i = 0; i < this.qls.length; i++) {
			if (this.qls[i]!=null&&this.qls[i].getKey().equals(key)) {
				return this.qls[i].getValue();
			}
		}
		return null;
	}
	public BaseQl[] getQls() {
		if (this.qls==null) {
			if (this.value!=null&&!this.value.equals("")) {
				String[] vs=this.value.split("\\|");
				this.qls=new BaseQl[vs.length];
				for (int i = 0; i < vs.length; i++) {
					String[] vss=vs[i].split("=");
					if (vss.length==2) {
						try {
							this.qls[i]=new BaseQl(vss[0], Double.parseDouble(vss[1]));	
						} catch (Exception e) {
							// TODO: handle exception
						}
					}	
				}
			}
		}
		return this.qls;
	}
}
