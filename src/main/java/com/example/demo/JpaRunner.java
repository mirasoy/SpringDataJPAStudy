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
		acc.setUsername("mira3");
		acc.setPassword("1234");
		
		Session session = entityManager.unwrap(Session.class);
		session.save(acc);
		//entityManager.persist(acc);
		
	}

	
	
	
}
