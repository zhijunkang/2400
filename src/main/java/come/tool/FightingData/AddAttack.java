package come.tool.FightingData;

public class AddAttack {
	private String type;
	private FightingSkill skill;
	private FightingSkill[] addSkill;
	public AddAttack(String type, FightingSkill skill, FightingSkill... addSkill) {
		super();
		this.type = type;
		this.skill = skill;
		this.addSkill=addSkill;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public FightingSkill getSkill() {
		return this.skill;
	}
	public void setSkill(FightingSkill skill) {
		this.skill = skill;
	}
	public FightingSkill[] getAddSkill() {
		return this.addSkill;
	}
	public void setAddSkill(FightingSkill[] addSkill) {
		this.addSkill = addSkill;
	}
}
