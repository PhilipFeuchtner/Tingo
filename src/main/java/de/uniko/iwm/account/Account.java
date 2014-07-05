package de.uniko.iwm.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;


@SuppressWarnings("serial")
@Entity
@Table(name = "account")
@NamedQuery(name = Account.FIND_BY_EMAIL, query = "select a from Account a where a.email = :email")
public class Account implements java.io.Serializable {

	public static final String FIND_BY_EMAIL = "Account.findByEmail";

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String email;

	@JsonIgnore
	private String password;

	private String role = "ROLE_USER";

	private String name;

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "ID")
//	private Set<QuestionGroup> questions;

	protected Account() {

	}

	public Account(String email, String password, String role) {
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
/*
	public Set<QuestionGroup> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<QuestionGroup> questions) {
		this.questions = questions;
	}
	*/
}
