package de.uniko.iwm.tingo.questiongroup;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import de.uniko.iwm.tingo.question.Question;

import org.codehaus.jackson.annotate.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "question")
@NamedQuery(name = QuestionGroup.FIND_BY_ID, query = "select a from QuestionGroup a where a.id = :id")
// @NamedQuery(name = Question.FIND_BY_GID, query = "select a from Question a where a.gid = :gid")

public class QuestionGroup implements java.io.Serializable {

	public static final String FIND_BY_ID = "QuestionGroup.findById";
	// public static final String FIND_BY_GID = "Question.findByGid";
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String displayName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID")
	private Set<Question> members;
	
	protected QuestionGroup() {

	}
	
	@PostConstruct	
	protected void initialize() {
		
	}

	public QuestionGroup(String displayName) {
		this.displayName = displayName;
	}
	
	public Long getId() {
		return id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Set<Question> getMembers() {
		return members;
	}

	public void setMembers(Set<Question> members) {
		this.members = members;
	}	
}
