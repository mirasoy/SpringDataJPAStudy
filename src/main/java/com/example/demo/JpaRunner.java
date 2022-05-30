package com.example.demo;


import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Component
@Transactional
public class JpaRunner implements ApplicationRunner{

	
	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Account acc = new Account();
		acc.setUsername("mira1");
		acc.setPassword("1234");
		
		Study study = new Study();
		study.setName("study1");
		acc.getStudies().add(study);
		study.setOwner(acc);
		
		acc.addStudy(study);
		
		Session session = entityManager.unwrap(Session.class);
		session.save(acc);
		session.save(study);
		//entityManager.persist(acc);
		
	}

	
	
	
}
