package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.comment.Commnet;
import com.example.demo.comment.CommnetRepository;
import com.example.demo.post.Post;
import com.example.demo.post.PostRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CommnetRepositoryTest {

	@Autowired
	CommnetRepository commnetRepository;
	
	@Autowired
	PostRepository  postRepository;
	
	@Test
	public void getCommnet() {
		
		commnetRepository.findAll();
		System.err.println("________________________");
		
		commnetRepository.findById(1l);
		
	}
	
	@Test
	public void getCommnet2() {
		
	}

	private Post createPost() {
		Post post = new Post();
		post.setTitle("spring title is this!");
		Post savePost = postRepository.save(post);
		return savePost;
	}

	
	
	
}
