package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.swing.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

	@Autowired
	PostRepository postRepository;

	@Test
	@Rollback(false)
	public void crudRepository() {
		
		//given
		Post post = new Post();
		post.setTitle("Test Post");
		//when
		Post newPost = postRepository.save(post);
		
		//given
		Post post2 = new Post();
		post2.setTitle("Test Post2");
		//when
		postRepository.save(post2);
		
		//then
		assertThat(newPost.getId()).isEqualTo(1);
		
		List<Post> postList = postRepository.findAll();
		//then
		assertEquals(postList.size(), 2);
		assertTrue(postList.contains(newPost));
		
		
		Page<Post> pageList =postRepository.findAll(PageRequest.of(0, 10));
		
		assertEquals(pageList.getNumber(),0);
		assertEquals(pageList.getSize(),10);
		assertEquals(pageList.getTotalElements(),2);
		
		pageList =postRepository.findByTitleContains("2", PageRequest.of(0, 10));
		
		assertEquals(pageList.getNumber(),0);
		assertEquals(pageList.getSize(),10);
		assertEquals(pageList.getTotalElements(),1);
		
		Long delete = postRepository.deleteByTitleContains("Post2");
		
		assertEquals(delete,1);
	}

}
