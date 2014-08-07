package de.uniko.iwm.Repo;

import java.util.ArrayList;
import java.util.List;

public class GroupItem {

	private List<QuestionItem> questionitemlist = new ArrayList<QuestionItem>();
	private List<Mediaobject> media = new ArrayList<Mediaobject>();
	private String base, title, image;
	private SimpleState state;
	private String index;
	
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
	
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
}
