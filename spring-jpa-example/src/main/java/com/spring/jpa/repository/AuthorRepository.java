package com.spring.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jpa.model.Author;
import com.spring.jpa.repository.base.BaseRepository;

public interface AuthorRepository extends BaseRepository<Author, Long>, AuthorRepositoryCustom, JpaSpecificationExecutor<Author>{

	@Query("from Author c where lower(c.name) like lower(?1)")
	Page<Author> getByNameWithQuery(String name, Pageable page);
	
	@Query("select case when (count(c) > 0)  then true else false end from Author c where c.name = ?1)")
	boolean exists(String name);		
	
	@Transactional
	int deleteByName(String name);
	
	@Query("from Author a where lower(a.name) like lower(?1)")
	Author findByNameWithQuery(@Param("name") String name);
}
