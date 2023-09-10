package org.come.model;
/**
 * 守护
 * @author Administrator
 *
 */
public class Save {
	
	// 主守护
	private Integer mainSave;
	
	// 副守护
	private Integer viceSave;
	
	// 贡献值
	private Integer contribute;

	public Integer getContribute() {
		return this.contribute;
	}

	public void setContribute(Integer contribute) {
		this.contribute = contribute;
	}

	public Integer getMainSave() {
		return this.mainSave;
	}

	public void setMainSave(Integer mainSave) {
		this.mainSave = mainSave;
	}

	public Integer getViceSave() {
		return this.viceSave;
	}

	public void setViceSave(Integer viceSave) {
		this.viceSave = viceSave;
	}
	
	
}
