package de.uniko.iwm.data;

import java.util.HashMap;

public class UserData {

	HashMap<String, QuizEntry> data;
	
	public UserData() {
		data = new HashMap<String, QuizEntry>();
	}
	
	public void addEntry(String index, QuizEntry entry) {
		data.put(index, entry);
	}

	public HashMap<String, QuizEntry> getData() {
		return data;
	}

	public void setData(HashMap<String, QuizEntry> data) {
		this.data = data;
	}
	
	
}
