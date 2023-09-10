package come.tool.Role;

import java.math.BigDecimal;

import org.come.entity.Lingbao;
import org.come.entity.Mount;

import come.tool.Calculation.BaseValue;
import come.tool.Calculation.GradeQl;

public class Hang {

	private BigDecimal id;//id
	private BigDecimal mid;//管制id 召唤兽使用
	private GradeQl pl;//品质,等级, 法宝使用
	
//	名称#类型#皮肤#过期时间(时间戳/60000)#作用描述^名称#类型#皮肤#过期时间(时间戳/60000)#作用描述
	public Hang(Lingbao lingbao,int is) {
		// TODO Auto-generated constructor stub
		this.id=lingbao.getBaoid();
	    if (is==1) {//法宝
	    	this.pl=new GradeQl(lingbao.getBaoname(),BaseValue.getQv(lingbao.getBaoquality()),lingbao.getLingbaolvl().intValue());
	    }
	}
	public Hang(BigDecimal id) {
		this.id=id;
	}
	/**修改管制id*/
	public void initSid(Mount mount){
		if (mount.getSid()!=null&&mount.getSid().compareTo(this.id)==0) {
			this.mid=mount.getMid();
		}else if (mount.getOthrersid()!=null&&mount.getOthrersid().compareTo(this.id)==0) {
			this.mid=mount.getMid();
		}else if (mount.getSid3()!=null&&mount.getSid3().compareTo(this.id)==0) {
			this.mid=mount.getMid();
		}else if (mount.getSid4()!=null&&mount.getSid4().compareTo(this.id)==0) {
		this.mid=mount.getMid();
		}else if (mount.getSid5()!=null&&mount.getSid5().compareTo(this.id)==0) {
	   this.mid=mount.getMid();
}
	}
	public BigDecimal getId() {
		return this.id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
//	public Double getHelpV() {
//		return helpV;
//	}
//	public void setHelpV(Double helpV) {
//		this.helpV = helpV;
//	}
	public BigDecimal getMid() {
		return this.mid;
	}
	public void setMid(BigDecimal mid) {
		this.mid = mid;
	}
	public GradeQl getPl() {
		return this.pl;
	}
	public void setPl(GradeQl pl) {
		this.pl = pl;
	}
}
