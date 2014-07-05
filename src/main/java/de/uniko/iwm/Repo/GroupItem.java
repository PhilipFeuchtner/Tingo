package de.uniko.iwm.Repo;

import java.util.List;

public class GroupItem {

	private List<QuestionItem> questionitemlist;
	private String title;
	
	private int index;
	
	public GroupItem() {
		
	}

	public List<QuestionItem> getQuestionitemlist() {
		return questionitemlist;
	}

	public void setQuestionitemlist(List<QuestionItem> questionitemlist) {
		this.questionitemlist = questionitemlist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
