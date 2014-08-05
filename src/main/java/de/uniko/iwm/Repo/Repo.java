package de.uniko.iwm.Repo;

import java.util.ArrayList;
import java.util.List;

public class Repo {

	private List<Section> sectionlist = new ArrayList<Section>();
	private Navigation navigation;

	public Repo() {

	}
	
	// -------------------- hepler -------------------------------
	
	public Section getSection() {
		return sectionlist.get(navigation.getSection());
	}

	public List<GroupItem> getGroups() {
		return sectionlist.get(navigation.getSection()).getGroupitemlist();
	}
	
	public GroupItem getGroupItem() {
		return sectionlist.get(navigation.getSection()).getGroupitemlist().get(navigation.getGroup());
	}

	public List<QuestionItem> getQuestions() {
		System.out.println(" ->: " + navigation);
		return sectionlist.get(navigation.getSection()).getGroupitemlist()
				.get(navigation.getGroup()).getQuestionitemlist();
	}
	
	public QuestionItem getQuestionItem() {
		return sectionlist.get(navigation.getSection()).getGroupitemlist()
				.get(navigation.getGroup()).getQuestionitemlist().get(navigation.getQuestion());
	}

	public void increment() {
		 sectionlist.get(navigation.getSection()).getGroupitemlist()
			.get(navigation.getGroup()).getState().increment();
	}
	
	// -----------------------------------------------------------
	
	public List<Section> getSectionlist() {
		return sectionlist;
	}

	public void setSectionlist(List<Section> sectionlist) {
		this.sectionlist = sectionlist;
	}

	public Navigation getNavigation() {
		return navigation;
	}

	public void setNavigation(Navigation navigation) {
		this.navigation = navigation;
	}

}
