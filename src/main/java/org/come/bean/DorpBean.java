package org.come.bean;

import java.util.Map;

import org.come.model.Dorp;
/**
 * 存放所有抽奖信息
 * @author Administrator
 *
 */
public class DorpBean {
	
	private Map<String, Dorp> dorpInfo;

	public Map<String, Dorp> getDorpInfo() {
		return this.dorpInfo;
	}

	public void setDorpInfo(Map<String, Dorp> dorpInfo) {
		this.dorpInfo = dorpInfo;
	}

}
