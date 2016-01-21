package com.spring.jpa.repository;

/**
 * 
 * @author ariel.duarte
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import com.spring.jpa.model.Person;

public class PersonRepositoryImpl implements PersonRepositoryCustom{

	@PersistenceContext private EntityManager em;

	/**
	 * Configure the entity manager to be used.
	 * 
	 * @param em the {@link EntityManager} to set.
	 */
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	
	@Override
	public List<Person> myCustomBatchOperation() {
		CriteriaQuery<Person> criteriaQuery = this.em.getCriteriaBuilder().createQuery(Person.class);
		criteriaQuery.select(criteriaQuery.from(Person.class));
		return this.em.createQuery(criteriaQuery).getResultList();
	}

}
