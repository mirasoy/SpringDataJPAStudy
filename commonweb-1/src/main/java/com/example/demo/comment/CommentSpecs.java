package com.example.demo.comment;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class CommentSpecs {

	public static Specification<Comment> isGood() {
		return new Specification<Comment>() {

			@Override
			public Predicate toPredicate(Root<Comment> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				// TODO Auto-generated method stub
				return builder.greaterThan(root.get(Comment_.up),10);
			}
		
		};

	}
	
	public static Specification<Comment> isBest() {
		return new Specification<Comment>() {
			
			@Override
			public Predicate toPredicate(Root<Comment> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				// TODO Auto-generated method stub
				return builder.isTrue(root.get(Comment_.best));
			}
			
		};
		
	}
}