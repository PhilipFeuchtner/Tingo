package de.uniko.iwm.Repo;

import java.util.List;

public class GroupItem {

	private List<QuestionItem> questionitemlist;
	private List<Mediaobject> media;
	private String base;
	private String title;
	private String image;
	private SimpleState state;
	
	public GroupItem() {
		state = new SimpleState();
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

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public SimpleState getState() {
		return state;
	}

	public void setState(SimpleState state) {
		this.state = state;
	}
}
