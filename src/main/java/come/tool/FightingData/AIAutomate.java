package come.tool.FightingData;


public class AIAutomate {

	private String type;
	private int bs;//0正常  1表示释放法术
	private int[] skills;
	
	public AIAutomate(String type,String[] vs) {
		super();
		this.type=type;
		if (type.equals(TypeUtil.JN)) {
			this.bs=1;
			vs=vs[2].split("_");
			this.skills=new int[vs.length];
			for (int i = 0; i < this.skills.length; i++) {
				this.skills[i]=Integer.parseInt(vs[i]);
			}
		}
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getBs() {
		return this.bs;
	}
	public void setBs(int bs) {
		this.bs = bs;
	}
	public int[] getSkills() {
		return this.skills;
	}
	public void setSkills(int[] skills) {
		this.skills = skills;
	}
	
}
