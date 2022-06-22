package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.comment.Comment;
import com.example.demo.comment.CommentOnly;
import com.example.demo.comment.CommentRepository;
import com.example.demo.comment.CommentSpecs;
import com.example.demo.post.Post;
import com.example.demo.post.PostRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommnetRepositoryTest {

	@Autowired
	CommentRepository commnetRepository;
	
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
		
		Post post = createPost();
		
		Comment comment= new Comment();
		comment.setComment("commnet");
		comment.setPost(post);
		comment.setUp(10);
		comment.setDown(3);
		commnetRepository.save(comment);
		
		List<CommentOnly> list = commnetRepository.findByPost_Id(post.getId(), CommentOnly.class);
		System.out.println("============================");
		list.forEach(c -> System.out.println(c.getComment()));
	}

	@Test
	public void SpecificationsTest() {
		commnetRepository.findAll(CommentSpecs.isGood());
	}
	
	@Test
	public void queryByExample() {
		Comment prove = new Comment();
		prove.setBest(true);
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny().withIgnorePaths("up", "down");
		
		Example<Comment> example = Example.of(prove,exampleMatcher);
		commnetRepository.findAll(example);
				
	
	
	}
	
	private Post createPost() {
		Post post = new Post();
		post.setTitle("spring title is this!");
		Post savePost = postRepository.save(post);
		return savePost;
	}

	
	
	
}
