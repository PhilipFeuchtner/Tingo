package de.uniko.iwm.tingo.task;

import java.util.ArrayList;
import java.util.List;

public class ResultListWrapper {

	private List<List<String>> resultList;
	private int i;
	
	public ResultListWrapper() {
        resultList = new ArrayList<List<String>>();
        i=0;
	}

	public List<List<String>> getResultList() {
		return resultList;
	}

	public void setResultList(List<List<String>> resultList) {
		this.resultList = resultList;
	}

	public void addQuestion() {
		resultList.add(new ArrayList<String>());
		i++;
	}
	
	public void add(String value) {
		resultList.get(i).add(value);
	}
}
