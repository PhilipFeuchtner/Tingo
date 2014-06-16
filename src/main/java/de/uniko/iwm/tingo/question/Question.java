package de.uniko.iwm.tingo.question;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "question")
@NamedQuery(name = Question.FIND_BY_ID, query = "select a from Question a where a.id = :id")
// @NamedQuery(name = Question.FIND_BY_GID, query = "select a from Question a where a.gid = :gid")

public class Question implements java.io.Serializable {

	public static final String FIND_BY_ID = "Question.findById";
	// public static final String FIND_BY_GID = "Question.findByGid";
	
	public enum State { UNSEEN, SEEN, SUBMITTED };
	public enum Type { SC, MC, FI };
	
	@Id
	@GeneratedValue
	private Long id;
	
	private State state;
	private Type type;
	
	private Long gid;
	
	private String correctValue;

	protected Question() {

	}

	public Question(Long gid, Type type, String correctValue) {
		this.gid = gid;
		this.type = type;
		this.correctValue = correctValue;
		
		state = State.UNSEEN;
	}

	public Long getId() {
		return id;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Long getGid() {
		return gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}

	public String getCorrectValue() {
		return correctValue;
	}

	public void setCorrectValue(String correctValue) {
		this.correctValue = correctValue;
	}
	
}
