package com.example.demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.post.Post;
import com.example.demo.post.PostRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {
	

	@Autowired
	PostRepository postRepository;
	
	@Test
	public void crudRepository() {
		Post post = new Post();
		assertFalse(postRepository.contains(post));
		
		post =  createPost("Spring post");
		assertTrue(postRepository.contains(post));
	}

	private Post createPost(String tiltle) {
		Post post = new Post();
		post.setTitle(tiltle);
		return postRepository.save(post);
	}
}
