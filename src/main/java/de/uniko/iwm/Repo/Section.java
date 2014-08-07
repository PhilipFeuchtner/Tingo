package de.uniko.iwm.Repo;

import java.util.ArrayList;
import java.util.List;

public class Section {

	private List<Entry> entries = new ArrayList<Entry>();
	
	private List<GroupItem> groupitemlist = new ArrayList<GroupItem>();
	private String title;
	private String svgid;
	private SimpleState state;
	private String index;
	
	
	
	public Section() {
		state = new SimpleState();
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	public List<GroupItem> getGroupitemlist() {
		return groupitemlist;
	}

	public void setGroupitemlist(List<GroupItem> groupitemlist) {
		this.groupitemlist = groupitemlist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSvgid() {
		return svgid;
	}

	public void setSvgid(String svgid) {
		this.svgid = svgid;
	}
	
	public SimpleState getState() {
		return state;
	}

	public void setState(SimpleState state) {
		this.state = state;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
	
}
