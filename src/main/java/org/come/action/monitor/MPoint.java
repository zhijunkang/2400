package org.come.action.monitor;

public class MPoint {

	//次数
	private long key;
	//产出值
	private long value;
	private Object object=new Object();
	public void add(long value){
		synchronized(this.object){
		   this.key++;
		   this.value+=value;
		}
	}
	public long getKey() {
		return this.key;
	}
	public void setKey(long key) {
		this.key = key;
	}
	public long getValue() {
		return this.value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	
}
