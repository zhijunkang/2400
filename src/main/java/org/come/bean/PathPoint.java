package org.come.bean;

public class PathPoint {
  
	private int x;
	private int y;
	public PathPoint() {
		// TODO Auto-generated constructor stub
	}
	public PathPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public void add(int v){
		this.x+=v;
		this.y+=v;
	}
	public int getX() {
		return this.x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return this.y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
