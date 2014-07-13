package de.uniko.iwm.Repo;

public class Navigation {

	private int section, group, question;
	
	public Navigation() {
		 section = group = question = 0;
	}

	public Navigation(int section, int group, int question) {
		this.section = section;
		this.group = group;
		this.question = question;
	}
	
	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		return "Navigation [" + section + ", " + group + ", " + question + "]";
	}
}
