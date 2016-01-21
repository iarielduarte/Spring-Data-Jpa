package com.spring.jpa.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.jpa.config.ApplicationConfig;
import com.spring.jpa.model.Customer;
import com.spring.jpa.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ApplicationConfig.class})
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void testCustomerRepository(){
		Customer c = new Customer();
		String cusName = "Test "+String.valueOf(System.currentTimeMillis());
		c.setName(cusName);
		customerRepository.save(c);
		assertTrue(customerRepository.findByNameWithQuery(cusName).getName().equals(cusName));
	}
	
}
