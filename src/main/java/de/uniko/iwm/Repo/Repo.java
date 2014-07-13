package de.uniko.iwm.Repo;

import java.util.List;

public class Repo {

	private List<Section> sectionlist;

	public Repo() {

	}

	public List<GroupItem> getGroups(Navigation nav) {
		return sectionlist.get(nav.getSection()).getGroupitemlist();
	}

	public List<QuestionItem> getQuestions(Navigation nav) {
		return sectionlist.get(nav.getSection()).getGroupitemlist()
				.get(nav.getQuestion()).getQuestionitemlist();
	}

	public List<Section> getSectionlist() {
		return sectionlist;
	}

	public void setSectionlist(List<Section> sectionlist) {
		this.sectionlist = sectionlist;
	}

}
