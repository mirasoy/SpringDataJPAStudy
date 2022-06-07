package com.example.demo;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.post.Post;
import com.example.demo.post.PostRepository;
import com.example.demo.post.QPost;
import com.querydsl.core.types.Predicate;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
public class PostRepositoryTest {
	

	@Autowired
	PostRepository postRepository;
	 
	@Test
	public void crudRepository() {
		Post post = new Post();
		post.setTitle("Spring post");
		postRepository.save(post);
		Predicate predicate = QPost.post.title.containsIgnoreCase("???");
		Optional<Post> post2 = postRepository.findOne(predicate);
	
	}

	
	
	
	
	private Post createPost(String tiltle) {
		Post post = new Post();
		post.setTitle(tiltle);
		return postRepository.save(post);
	}
}
