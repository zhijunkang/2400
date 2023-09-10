package come.tool.Scene.DNTG;

public class DNTG_SG {
	
	private long endTime;//倒计时结束时间
	private int max;
	private int TT_GX;
	private int HGS_GX;
	
	public DNTG_SG() {
		super();
		this.endTime=System.currentTimeMillis()+30*60*1000;
		this.max=1000;
	}
	public boolean isEnd(){
		return this.TT_GX>=this.max||this.HGS_GX>=this.max;
	}
	public int getEnd(){
		if (this.TT_GX>this.HGS_GX) {
			return 0;
		}else if (this.HGS_GX>this.TT_GX) {
			return 1;
		}
		return -1;
	}
	public void toString(StringBuffer buffer){
		buffer.append("|S2");
		buffer.append(this.endTime);
		buffer.append("&");
		buffer.append(this.max);
		buffer.append("|S0");
		buffer.append(this.TT_GX);
		buffer.append("|S1");
		buffer.append(this.HGS_GX);
	}
	public long getEndTime() {
		return this.endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public int getMax() {
		return this.max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getTT_GX() {
		return this.TT_GX;
	}
	public void setTT_GX(int tT_GX) {
		this.TT_GX = tT_GX;
	}
	public int getHGS_GX() {
		return this.HGS_GX;
	}
	public void setHGS_GX(int hGS_GX) {
		this.HGS_GX = hGS_GX;
	}
	
}
