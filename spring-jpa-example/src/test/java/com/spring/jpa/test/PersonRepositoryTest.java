package com.spring.jpa.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.jpa.config.ApplicationConfig;
import com.spring.jpa.model.Person;
import com.spring.jpa.repository.PersonRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ApplicationConfig.class})
public class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;
	
	

	@Test
	public void testPersonRepository(){
		Person person = new Person();
		String firstName = "Test Insert Person - First Name"+String.valueOf(System.currentTimeMillis());
		String lastName = "Test Insert Person - Last Name"+String.valueOf(System.currentTimeMillis());
		person.setFirstName(firstName);
		person.setLastName(lastName);
		
		/* Verify person was saved*/
		personRepository.save(person);
		assertEquals(person, personRepository.findOne(person.getId()));
		
		/* Verify invocation of custom method.*/
		List<Person> persons = personRepository.myCustomBatchOperation();
		assertNotNull(persons);
		
		int lastIdIndex = persons.size();
		String firstNameExpected = persons.get(lastIdIndex-1).getFirstName();
		assertTrue(firstName.equals(firstNameExpected));
		
		/* Verify person was removed*/
		personRepository.delete(person);
		assertEquals(null,personRepository.findOne(person.getId()));
	}
	
	
}
