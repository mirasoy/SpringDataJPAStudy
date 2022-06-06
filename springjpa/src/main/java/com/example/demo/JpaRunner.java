package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

	
	@Autowired
	PostRepository  postRepo;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

//		Post post = new Post();
//		post.setTitle("파라미터 찍히는가?");
//		
//		Comment comment = new Comment();
//		comment.setComment("코멘트도저장되는가");
//		
//		post.addComment(comment);
//		postRepo.save(post);
//		
		
		
		
		postRepo.findAll().forEach(System.out::println);
		
	}

}
