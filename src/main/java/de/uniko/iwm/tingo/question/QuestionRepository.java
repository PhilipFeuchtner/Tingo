package de.uniko.iwm.tingo.question;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class QuestionRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Question save(Question question) {
		entityManager.persist(question);
		return question;
	}
	
	public Question findById(Long id) {
		try {
			return entityManager.createNamedQuery(Question.FIND_BY_ID, Question.class)
					.setParameter("id", id)
					.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}

	
}
