package com.spring.jpa.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.jpa.config.ApplicationConfig;
import com.spring.jpa.model.Author;
import com.spring.jpa.repository.AuthorRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ApplicationConfig.class})
public class AuthorRepositoryTest {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Test
	public void testCustomerRepository(){
		Author author = new Author();
		String authorName = "Test insert author "+String.valueOf(System.currentTimeMillis());
		author.setName(authorName);
		authorRepository.save(author);
		assertTrue(authorRepository.findByNameWithQuery(authorName).getName().equals(authorName));
	}
	
}
