package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.swing.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

	@Autowired
	CommentRepository commendRepository;
	
	@Test
	@Rollback(false)
	public void crudRepository() {
		
		this.creatComment(10, "Spring JPA Test");
		this.creatComment(100,"SPRING now");
		
		PageRequest pageable = PageRequest.of(0,10, Sort.by(Sort.Direction.DESC, "likeCount"));
		

		try(Stream<Comment> list = commendRepository.findByCommentContainsIgnoreCase("spring", pageable)){
			assertEquals(list.findFirst().get().getLikeCount(), 100);
		}
		
		
	}

	private void creatComment(int like, String com) {
		Comment comment = new Comment();
		comment.setComment(com);
		comment.setLikeCount(like);
		commendRepository.save(comment);
	}

}
