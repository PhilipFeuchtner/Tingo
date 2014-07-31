package de.uniko.iwm.Repo;

import java.util.ArrayList;
import java.util.List;

public class Section {

	private List<GroupItem> groupitemlist = new ArrayList<GroupItem>();
	private String title;
	private String svgid;
	private String index;
	
	public Section() {
		
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

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
}
