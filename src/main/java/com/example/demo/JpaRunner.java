package com.example.demo;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		/* JPQL (HQL) */
	//	TypedQuery<Post> query = entityManager.createQuery("Select b from Post as b", Post.class);
	//	List<Post> result = query.getResultList();
	//	result.forEach(System.out::println);
		
		
		/* Criteria */
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Post> criteria = builder.createQuery(Post.class);
//		Root<Post> root = criteria.from(Post.class);
//		criteria.select(root);
//		List<Post> result = entityManager.createQuery(criteria).getResultList();
		
		
		/* Native Query */
		List<Post> result = entityManager.createNativeQuery("select * from Post", Post.class).getResultList();
		result.forEach(System.out::println);
	}

}
