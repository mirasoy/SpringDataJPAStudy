package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.comment.Comment;
import com.example.demo.comment.CommentOnly;
import com.example.demo.comment.CommentRepository;
import com.example.demo.post.Post;
import com.example.demo.post.PostRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
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
//		List<CommentSummary> list = commnetRepository.findByPost_Id(post.getId(), CommentSummary.class);
//		System.out.println("============================");
//		list.forEach(c -> System.out.println(c.getVotes()));
		
		List<CommentOnly> list = commnetRepository.findByPost_Id(post.getId(), CommentOnly.class);
		System.out.println("============================");
		list.forEach(c -> System.out.println(c.getComment()));
	}

	private Post createPost() {
		Post post = new Post();
		post.setTitle("spring title is this!");
		Post savePost = postRepository.save(post);
		return savePost;
	}

	
	
	
}
