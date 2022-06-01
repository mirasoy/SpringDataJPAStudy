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
		/*
		 * Post post = new Post(); post.setTitle("post title");
		 * 
		 * Comment comment = new Comment(); comment.setComment("commnet1");
		 * post.addComment(comment);
		 * 
		 * Comment comment1 = new Comment(); comment1.setComment("commnet2");
		 * post.addComment(comment1);
		 */
		
		Session session = entityManager.unwrap(Session.class);
		
		Post post = session.load(Post.class,1L);
;		session.delete(post);
	}

	
	
	
}
