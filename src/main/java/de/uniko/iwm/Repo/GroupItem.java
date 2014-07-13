package de.uniko.iwm.Repo;

import java.util.List;

public class GroupItem {

	private List<QuestionItem> questionitemlist;
	private List<Mediaobject> media;
	private String title;
	private int count;
	private String image;
	
	public GroupItem() {
		
	}

	public List<QuestionItem> getQuestionitemlist() {
		return questionitemlist;
	}

	public void setQuestionitemlist(List<QuestionItem> questionitemlist) {
		this.questionitemlist = questionitemlist;
	}

	public List<Mediaobject> getMedia() {
		return media;
	}

	public void setMedia(List<Mediaobject> media) {
		this.media = media;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
