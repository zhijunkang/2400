package come.tool.Calculation;

public class GradeQl {

	private String type;
	private int P;//多少等级换算一点D
	private double V;//基础点数数值
	
	public GradeQl(String type, int p, double v) {
		super();
		this.type = type;
		this.P = p;
		this.V = v;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getP() {
		return this.P;
	}
	public void setP(int p) {
		this.P = p;
	}
	public double getV() {
		return this.V;
	}
	public void setV(double v) {
		this.V = v;
	}
	
}
