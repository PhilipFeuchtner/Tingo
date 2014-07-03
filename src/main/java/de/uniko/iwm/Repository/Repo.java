package de.uniko.iwm.Repository;

import java.util.List;

public class Repo {
	
	private List<GroupItem> groupitemlist;
	private String test;
	
	public Repo() {
		
	}

	public List<GroupItem> getGroupitemlist() {
		return groupitemlist;
	}

	public void setGroupitemlist(List<GroupItem> groupitemlist) {
		this.groupitemlist = groupitemlist;
	}
	
	public void setTest(String test) {
		this.test = test;
	}
}
