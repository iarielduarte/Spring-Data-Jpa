package com.spring.jpa.repository.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class BaseRepositoryImpl <T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID>{

	private EntityManager entityManager;
	
	private Class<T> clazz;
	
	public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.entityManager = em; 
		clazz = domainClass;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAllBase() {
		Query query = entityManager.createQuery("from " + clazz.getName());
		return query.getResultList();
	}

}
