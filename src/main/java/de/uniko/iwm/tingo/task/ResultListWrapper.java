package de.uniko.iwm.tingo.task;

import java.util.ArrayList;
import java.util.List;

public class ResultListWrapper {

	private List<List<String>> resultList;
	
	private int count_questions, count_tasks;
	
	public ResultListWrapper() {
        resultList = new ArrayList<List<String>>();
        
		count_questions = 0;
		count_tasks = 0;
	}

	public List<List<String>> getResultList() {
		return resultList;
	}

	public void setResultList(List<List<String>> resultList) {
		this.resultList = resultList;
	}

	public void addQuestion() {
		count_questions++;
		count_tasks = 0;

		if (count_questions > resultList.size()) {
			List<String> tasks = new ArrayList<String>();
			resultList.add(tasks);
		}
	}
	
	public void add(String value) {		
		count_tasks++;

		List<String> tasks = resultList.get(count_questions - 1);

		if (count_tasks > tasks.size()) {
			tasks.add(value);
		} else {
			tasks.set(count_tasks - 1, value);
		}
	}
}
