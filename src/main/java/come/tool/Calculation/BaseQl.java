package come.tool.Calculation;

public class BaseQl {
	private String key;
	private double value;
	
	public BaseQl(String key, double value) {
		super();
		this.key = key;
		this.value = value;
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
	
}
