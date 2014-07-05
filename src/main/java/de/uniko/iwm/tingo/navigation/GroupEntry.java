package de.uniko.iwm.tingo.navigation;

public class GroupEntry {

	private String title;
	private String svgid;

	public GroupEntry() {
		
	}

	public GroupEntry(String title, String svgid) {
		this.title = title;
		this.svgid = svgid;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSvgid() {
		return svgid;
	}

	public void setSvgid(String svgid) {
		this.svgid = svgid;
	}
	
	
}
