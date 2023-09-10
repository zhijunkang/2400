package org.come.bean;

public class Coordinates {

	private int mapID;
	private int x;
	private long y;
	
	public Coordinates(int mapID, int x, long l) {
		super();
		this.mapID = mapID;
		this.x = x;
		this.y = l;
	}
	public int getMapID() {
		return this.mapID;
	}
	public void setMapID(int mapID) {
		this.mapID = mapID;
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
