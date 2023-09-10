package come.tool.oneArena;

import java.util.List;

public class OneArenaBean {

	private int place;//自己排名  数据是0 不刷新排名 
	private List<OneArenaRole> arenaList;//挑战人的数据
	private List<OneArenaNotes> notesList;//战报刷新
	private OneArenaNotes notes;
	public int getPlace() {
		return this.place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	public List<OneArenaRole> getArenaList() {
		return this.arenaList;
	}
	public void setArenaList(List<OneArenaRole> arenaList) {
		this.arenaList = arenaList;
	}
	public List<OneArenaNotes> getNotesList() {
		return this.notesList;
	}
	public void setNotesList(List<OneArenaNotes> notesList) {
		this.notesList = notesList;
	}
	public OneArenaNotes getNotes() {
		return this.notes;
	}
	public void setNotes(OneArenaNotes notes) {
		this.notes = notes;
	}
}
