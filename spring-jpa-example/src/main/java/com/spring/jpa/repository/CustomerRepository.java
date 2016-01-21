package com.spring.jpa.repository;

/**
 * 
 * @author ariel.duarte
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.jpa.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query("from Customer c where lower(c.name) like lower(?1)")
	Customer findByNameWithQuery(@Param("name") String name);

}
