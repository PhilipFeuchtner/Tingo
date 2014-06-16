package de.uniko.iwm.tingo.questiongroup;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class QuestionGroupRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public QuestionGroup save(QuestionGroup question) {
		entityManager.persist(question);
		return question;
	}
	
	public QuestionGroup findById(Long id) {
		try {
			return entityManager.createNamedQuery(QuestionGroup.FIND_BY_ID, QuestionGroup.class)
					.setParameter("id", id)
					.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}

	
}
