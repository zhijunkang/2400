package org.come.readBean;

/**
 * 新手引导Bean类
 */
public class RookieGuideBean {
	
	private int Gid;//表ID
	private String Guidename; //小项名称
	private int Fid; //所属大项ID
	private String Bootcontent;//引导内容
	public int getGid() {
		return this.Gid;
	}
	public void setGid(int gid) {
		this.Gid = gid;
	}
	public String getGuidename() {
		return this.Guidename;
	}
	public void setGuidename(String guidename) {
		this.Guidename = guidename;
	}
	public int getFid() {
		return this.Fid;
	}
	public void setFid(int fid) {
		this.Fid = fid;
	}
	public String getBootcontent() {
		return this.Bootcontent;
	}
	public void setBootcontent(String bootcontent) {
		this.Bootcontent = bootcontent;
	}
	
	
}
