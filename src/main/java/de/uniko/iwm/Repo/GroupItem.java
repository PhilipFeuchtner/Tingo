package de.uniko.iwm.Repo;

import java.util.List;

public class GroupItem {

	private List<QuestionItem> questionitemlist;
	private List<String> media;
	private String title;
	private int count;
	private String image;
	
	private int index;
	
	public GroupItem() {
		
	}

	public List<QuestionItem> getQuestionitemlist() {
		return questionitemlist;
	}

	public void setQuestionitemlist(List<QuestionItem> questionitemlist) {
		this.questionitemlist = questionitemlist;
	}

	public List<String> getMedia() {
		return media;
	}

	public void setMedia(List<String> media) {
		this.media = media;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
