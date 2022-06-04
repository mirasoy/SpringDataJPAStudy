package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

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
public class CommentRepositoryTest {

	@Autowired
	CommentRepository commendRepository;
	
	@Test
	@Rollback(false)
	public void crudRepository() {
		
		/*Comment comment = new  Comment();
		comment.setComment("hi yo");
		commendRepository.save(comment);
		
		List<Comment> all =  commendRepository.findAll();
		assertThat(all.size()).isEqualTo(1);
		*/
		
		
		Optional<Comment> byId =  commendRepository.findById(100l);
		assertThat(byId).isEmpty();
		
		commendRepository.save(null);
	}

}
