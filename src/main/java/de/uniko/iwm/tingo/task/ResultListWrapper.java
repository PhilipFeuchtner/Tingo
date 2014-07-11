package de.uniko.iwm.tingo.task;

import java.util.ArrayList;
import java.util.List;

public class ResultListWrapper {

	private List<String> resultList;
	private List<Integer> questionIndices;

	
	public ResultListWrapper() {
        resultList = new ArrayList<String>();
        questionIndices = new ArrayList<Integer>();
	}

	public List<String> getResultList() {
		return resultList;
	}

	public void setResultList(List<String> resultList) {
		this.resultList = resultList;
	}

	public void addQuestion() {
		questionIndices.add(resultList.size());
	}
	
	public void add(String value) {
		resultList.add(value);
	}
	
	public List<Integer> getQuestionIndices() {
		return questionIndices;
	}
}
