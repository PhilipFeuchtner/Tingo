package de.uniko.iwm.Repo;

import java.util.List;

public class Repo {
	
	private List<Section> sectionlist;
	private int index;
	
	public Repo() {
		
	}

	public List<Section> getSectionlist() {
		return sectionlist;
	}

	public void setSectionlist(List<Section> sectionlist) {
		this.sectionlist = sectionlist;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
}
