package org.come.bean;

public class Bbuy {
	private Integer gid;
	private long price1;
	private long price2;
	//最大收购数
    private transient int maxNum;
    //当前已收数量
    private transient int num;    
    public int addNum(int size){
    	if (this.maxNum==0) {return size;}
    	if (this.num>=this.maxNum) {return 0;}
    	this.num+=size;
    	if (this.num>this.maxNum) {
    		size=this.num-this.maxNum;
    		this.num=this.maxNum;
    		return size;
		}
		return size;
    }
	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public long getPrice1() {
		return this.price1;
	}

	public void setPrice1(long price1) {
		this.price1 = price1;
	}

	public long getPrice2() {
		return this.price2;
	}

	public void setPrice2(long price2) {
		this.price2 = price2;
	}
	public int getMaxNum() {
		return this.maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public int getNum() {
		return this.num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
