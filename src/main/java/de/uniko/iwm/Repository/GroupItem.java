package de.uniko.iwm.Repository;

import java.util.List;

public class GroupItem {

	private List<QuestionItem> questionitemlist;
	
	public GroupItem() {
		
	}

	public List<QuestionItem> getQuestionitemlist() {
		return questionitemlist;
	}

	public void setQuestionitemlist(List<QuestionItem> questionitemlist) {
		this.questionitemlist = questionitemlist;
	}
}
