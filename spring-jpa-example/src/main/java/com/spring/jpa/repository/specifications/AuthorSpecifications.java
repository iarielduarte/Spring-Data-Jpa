package com.spring.jpa.repository.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.spring.jpa.model.Author;

public abstract class AuthorSpecifications {

	public static Specification<Author> searchByName(final String name) {
		return new Specification<Author>() {

			@Override
			public Predicate toPredicate(Root<Author> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder)
			{
				return criteriaBuilder.equal(root.get("name"), name);
			}
		};
	}

}
