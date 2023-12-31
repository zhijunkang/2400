package come.tool.Scene.LTS;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.come.bean.PathPoint;

public class LTSBean {

	//积分清理次数
	private int ci;	
	private BigDecimal[] ids;//有称谓的集合
	private ConcurrentHashMap<BigDecimal,PathPoint> ltsMap;
	public LTSBean() {
		// TODO Auto-generated constructor stub
		this.ids=new BigDecimal[0];
		this.ltsMap=new ConcurrentHashMap<>();
	}
	/**积分重置要求*/
	public void resetL(int i){
		if (i==0) {//重置可用积分
			Iterator<Entry<BigDecimal, PathPoint>> entries = this.ltsMap.entrySet().iterator();
			while (entries.hasNext()) {
				Entry<BigDecimal, PathPoint> entrys = entries.next();
				entrys.getValue().setY(0);
			}	
		}else {//全部重置
			this.ci=0;
			this.ltsMap.clear();
		}
	}
	public int getCi() {
		return this.ci;
	}
	public void setCi(int ci) {
		this.ci = ci;
	}
	public ConcurrentHashMap<BigDecimal, PathPoint> getLtsMap() {
		return this.ltsMap;
	}
	public void setLtsMap(ConcurrentHashMap<BigDecimal, PathPoint> ltsMap) {
		this.ltsMap = ltsMap;
	}
	public BigDecimal[] getIds() {
		return this.ids;
	}
	public void setIds(BigDecimal[] ids) {
		this.ids = ids;
	}
	
	
}
