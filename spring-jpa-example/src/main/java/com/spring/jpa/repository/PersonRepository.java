package com.spring.jpa.repository;

/**
 * 
 * @author ariel.duarte
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.jpa.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepositoryCustom {

	
	@Query("select u from Person u where u.firstName = :firstname")
	List<Person> findByFirstName(String firstname);
}
