package come.tool.Role;

public class PartJade {

	private int suitid;//套装id
	private int partId;//部件id
	private int jade1;//把玩数量
	private int jade2;//贴身数量
	private int jade3;//珍藏数量
	private int jade4;//无价数量
	private int jade5;//传世数量
	public PartJade(int suitid, int partId) {
		super();
		this.suitid = suitid;
		this.partId = partId;
	}
	/**初始化玉符数量*/
	public void initJade(String[] jades){
		this.jade1=Integer.parseInt(jades[1]);
		this.jade2=Integer.parseInt(jades[2]);
		this.jade3=Integer.parseInt(jades[3]);
		this.jade4=Integer.parseInt(jades[4]);
		this.jade5=Integer.parseInt(jades[5]);		
	}
	/**判断是否为空玉符 空玉符 true*/
	public boolean isJade(){
		if (this.jade1>0||this.jade2>0||this.jade3>0||this.jade4>0||this.jade5>0) {
			return false;
		}
		return true;
	}
	/**修改玉符*/
	public void setJade(int pz,int sum){
		switch (pz) {
		case 1:this.jade1+=sum;break;
		case 2:this.jade2+=sum;break;
		case 3:this.jade3+=sum;break;
		case 4:this.jade4+=sum;break;
		case 5:this.jade5+=sum;break;
		}
	}
	/**获取某一品质玉符*/
	public int getJade(int pz){
		int num = 0;
		switch (pz) {
		case 1:num=this.jade1;break;
		case 2:num=this.jade2;break;
		case 3:num=this.jade3;break;
		case 4:num=this.jade4;break;
		case 5:num=this.jade5;break;
		}
		return num;
	}
	public int getSuitid() {
		return this.suitid;
	}
	public void setSuitid(int suitid) {
		this.suitid = suitid;
	}
	public int getPartId() {
		return this.partId;
	}
	public void setPartId(int partId) {
		this.partId = partId;
	}
	public int getJade1() {
		return this.jade1;
	}
	public void setJade1(int jade1) {
		this.jade1 = jade1;
	}
	public int getJade2() {
		return this.jade2;
	}
	public void setJade2(int jade2) {
		this.jade2 = jade2;
	}
	public int getJade3() {
		return this.jade3;
	}
	public void setJade3(int jade3) {
		this.jade3 = jade3;
	}
	public int getJade4() {
		return this.jade4;
	}
	public void setJade4(int jade4) {
		this.jade4 = jade4;
	}
	public int getJade5() {
		return this.jade5;
	}
	public void setJade5(int jade5) {
		this.jade5 = jade5;
	}
	@Override
	public String toString(){
		StringBuffer buffer=new StringBuffer();
		buffer.append(this.partId);
		buffer.append("_");
		buffer.append(this.jade1);
		buffer.append("_");
		buffer.append(this.jade2);
		buffer.append("_");
		buffer.append(this.jade3);
		buffer.append("_");
		buffer.append(this.jade4);
		buffer.append("_");
		buffer.append(this.jade5);
		return buffer.toString();
		
	}
}
