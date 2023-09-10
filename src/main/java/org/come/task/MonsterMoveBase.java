package org.come.task;

import java.util.ArrayList;
import java.util.List;

import org.come.bean.PathPoint;

//TODO 移动类怪物移动路径
public class MonsterMoveBase {
	
	private int bh;//路径编号
	private List<PathPoint> points;//路径数据
	private String moveMsg;
	private int endTime;//路径所需时间
	//0-3 蟠桃园路径   5-9长安保卫战     10-15 大闹天宫路径
	public MonsterMoveBase(int bh) {
		super();
		this.bh=bh;
		if (bh>=0&&bh<=3) {
			BTY(bh);	
		}else if (bh>=5&&bh<=9) {
			BWZ(bh);
		}else if (bh>=10&&bh<=15) {
			DNTG(bh);	
		}
		StringBuffer buffer=new StringBuffer();
		buffer.append(bh);
		for (int i=0;i<this.points.size();i++) {
			PathPoint point=this.points.get(i);
			buffer.append("^");buffer.append(point.getX());
			buffer.append("^");buffer.append(point.getY());
		}
		this.moveMsg=buffer.toString();	
		for (int i = 1; i < this.points.size(); i++) {
			PathPoint pointOne=this.points.get(i-1);
			PathPoint pointTwo=this.points.get(i);
			this.endTime+=gettime(pointTwo.getX()-pointOne.getX(),pointTwo.getY()-pointOne.getY(),0.067);
		}
	}
	/**根据速度和距离换算时间*/
	public static double gettime(long l, long m, double sp) {
		double move = Math.sqrt(l * l + m * m);
		return move / sp;
	}
	private void DNTG(int I) {
		I -= 10;
		this.points = new ArrayList<>();
		if (I % 3 == 0) {
			this.points.add(new PathPoint(2800, 940));
			this.points.add(new PathPoint(4010, 350));
			this.points.add(new PathPoint(4790, 410));
			this.points.add(new PathPoint(5970, 230));
			this.points.add(new PathPoint(6990, 310));
			this.points.add(new PathPoint(7850, 510));
			this.points.add(new PathPoint(8310, 970));
			this.points.add(new PathPoint(8310, 1270));
			this.points.add(new PathPoint(8590, 1570));
			this.points.add(new PathPoint(8490, 1670));
			this.points.add(new PathPoint(8590, 1950));
			this.points.add(new PathPoint(8430, 2130));
			this.points.add(new PathPoint(8690, 2730));
		} else if (I % 3 == 1) {
			this.points.add(new PathPoint(2100, 1760));
			this.points.add(new PathPoint(3010, 1730));
			this.points.add(new PathPoint(3510, 1750));
			this.points.add(new PathPoint(3910, 2150));
			this.points.add(new PathPoint(3910, 2170));
			this.points.add(new PathPoint(4870, 3130));
			this.points.add(new PathPoint(5530, 3170));
			this.points.add(new PathPoint(6290, 2930));
			this.points.add(new PathPoint(6690, 3050));
		} else if (I % 3 == 2) {
			this.points.add(new PathPoint(720, 1720));
			this.points.add(new PathPoint(810, 2010));
			this.points.add(new PathPoint(510, 2330));
			this.points.add(new PathPoint(530, 2590));
			this.points.add(new PathPoint(290, 2890));
			this.points.add(new PathPoint(210, 3610));
			this.points.add(new PathPoint(250, 3670));
			this.points.add(new PathPoint(390, 3810));
			this.points.add(new PathPoint(810, 4010));
			this.points.add(new PathPoint(2070, 3670));
			this.points.add(new PathPoint(2210, 3570));
			this.points.add(new PathPoint(4210, 3970));
			this.points.add(new PathPoint(4670, 3910));
			this.points.add(new PathPoint(6110, 3670));
			this.points.add(new PathPoint(6150, 3690));
			this.points.add(new PathPoint(6470, 3670));
		}
		if (I >= 3) {
			List<PathPoint> list2 = new ArrayList<>();
			for (int j = this.points.size() - 1; j >= 0; j--) {
				list2.add(this.points.get(j));
			}
			this.points = list2;
		}
	}
	public void BWZ(int I) {
		//6130-1630点一 5970-1530点二 5830-1610点三  5990-1770点四  5970-1990点五
		I-=5;
		this.points=new ArrayList<>();
		if (I==0) {
			this.points.add(new PathPoint(6130, 1630));
		}else if (I==1) {
			this.points.add(new PathPoint(5970, 1530));
		}else if (I==2) {
			this.points.add(new PathPoint(5830, 1610));
		}else if (I==3) {
			this.points.add(new PathPoint(5990, 1770));
		}else if (I==4) {
			this.points.add(new PathPoint(5970, 1990));
		}
		if (I!=4) {this.points.add(new PathPoint(5970, 1990));}
		this.points.add(new PathPoint(5990, 2710));
		this.points.add(new PathPoint(5750, 3430));
		this.points.add(new PathPoint(5570, 3730));
		this.points.add(new PathPoint(5550, 3750));
		this.points.add(new PathPoint(5430, 3850));
		this.points.add(new PathPoint(4810, 3910));
		this.points.add(new PathPoint(4470, 3870));
		this.points.add(new PathPoint(4150, 3670));
		this.points.add(new PathPoint(2930, 2550));
		this.points.add(new PathPoint(2790, 2550));
		this.points.add(new PathPoint(490, 690));
	}
	private void BTY(int I) {
		if (I == 0) {
			this.points = new ArrayList<>();
			this.points.add(new PathPoint(1582, 2192));
			this.points.add(new PathPoint(730, 2070));
			this.points.add(new PathPoint(690, 2050));
			this.points.add(new PathPoint(610, 1970));
			this.points.add(new PathPoint(390, 1510));
			this.points.add(new PathPoint(390, 1470));

			this.points.add(new PathPoint(740, 1080));
			this.points.add(new PathPoint(1420, 1080));
			this.points.add(new PathPoint(1260, 820));
			this.points.add(new PathPoint(1600, 520));
			this.points.add(new PathPoint(1830, 590));
		} else if (I == 1) {
			this.points = new ArrayList<>();
			this.points.add(new PathPoint(1676, 2592));
			this.points.add(new PathPoint(950, 2250));
			this.points.add(new PathPoint(690, 2050));
			this.points.add(new PathPoint(610, 1970));
			this.points.add(new PathPoint(390, 1510));
			this.points.add(new PathPoint(390, 1470));
			this.points.add(new PathPoint(390, 1470));
			this.points.add(new PathPoint(740, 1080));
			this.points.add(new PathPoint(1420, 1080));
			this.points.add(new PathPoint(1260, 820));
			this.points.add(new PathPoint(1600, 520));
			this.points.add(new PathPoint(1830, 590));
		} else if (I == 2) {
			this.points = new ArrayList<>();
			this.points.add(new PathPoint(1116, 2682));
			this.points.add(new PathPoint(1270, 2630));
			this.points.add(new PathPoint(1330, 2590));
			this.points.add(new PathPoint(1390, 2530));
			this.points.add(new PathPoint(1030, 2270));
			this.points.add(new PathPoint(950, 2250));
			this.points.add(new PathPoint(690, 2050));
			this.points.add(new PathPoint(610, 1970));
			this.points.add(new PathPoint(390, 1510));
			this.points.add(new PathPoint(390, 1470));

			this.points.add(new PathPoint(740, 1080));
			this.points.add(new PathPoint(1420, 1080));
			this.points.add(new PathPoint(680, 760));
			this.points.add(new PathPoint(1260, 820));
			this.points.add(new PathPoint(1600, 520));
			this.points.add(new PathPoint(1830, 590));
		} else if (I == 3) {
			this.points = new ArrayList<>();
			this.points.add(new PathPoint(1694, 1733));
			this.points.add(new PathPoint(1510, 1690));
			this.points.add(new PathPoint(1270, 1570));
			this.points.add(new PathPoint(1250, 1550));
			this.points.add(new PathPoint(1170, 1410));
			this.points.add(new PathPoint(1160, 1200));
			this.points.add(new PathPoint(600, 800));
			this.points.add(new PathPoint(1260, 820));
			this.points.add(new PathPoint(1600, 520));
			this.points.add(new PathPoint(1830, 590));
		}
	}
	
	public int getBh() {
		return this.bh;
	}
	public void setBh(int bh) {
		this.bh = bh;
	}
	public List<PathPoint> getPoints() {
		return this.points;
	}
	public void setPoints(List<PathPoint> points) {
		this.points = points;
	}
	public String getMoveMsg() {
		return this.moveMsg;
	}
	public void setMoveMsg(String moveMsg) {
		this.moveMsg = moveMsg;
	}
	public int getEndTime() {
		return this.endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
}
