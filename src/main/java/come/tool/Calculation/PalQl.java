package come.tool.Calculation;

public class PalQl {

	private String key;//字段
	private double value;//初始
	private double sv;//每级添加
	
	public PalQl(String key, double value, double sv) {
		super();
		this.key = key;
		this.value = value;
		this.sv = sv;
	}
	public String getKey() {
		return this.key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public double getValue() {
		return this.value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getSv() {
		return this.sv;
	}
	public void setSv(double sv) {
		this.sv = sv;
	}
	
}
