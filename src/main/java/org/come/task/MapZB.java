package org.come.task;

public class MapZB {
	private String map;
	private int x;
	private long y;
	
	public MapZB(String map, int x, long l) {
		super();
		this.map = map;
		this.x = x;
		this.y = l;
	}
	public String getMap() {
		return this.map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	public int getX() {
		return this.x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public long getY() {
		return this.y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
