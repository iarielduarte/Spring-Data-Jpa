package com.spring.jpa.repository;

/**
 * 
 * @author ariel.duarte
 */

import java.util.List;

import com.spring.jpa.model.Person;

public interface PersonRepositoryCustom {
	
	/**
	 * Custom repository operation.
	 * 
	 * @return
	 */
	List<Person> myCustomBatchOperation();
}
