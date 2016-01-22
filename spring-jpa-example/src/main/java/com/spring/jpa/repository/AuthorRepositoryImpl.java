package com.spring.jpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jpa.model.Author;

public class AuthorRepositoryImpl implements AuthorRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;	
	
	@Override
	@Transactional
	public void clearEntityCache() {
		SessionFactory sessionFactory = entityManager.unwrap(Session.class).getSessionFactory();
		sessionFactory.getCache().evictEntityRegion(Author.class);
		
	}

}
