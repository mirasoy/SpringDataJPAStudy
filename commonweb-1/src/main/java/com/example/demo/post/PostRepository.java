package com.example.demo.post;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByTitleStartsWith(String string);

	
	@Query("SELECT p FROM Post as p WHERE p.title = ?1")
	List<Post> findByTitle(String string, Sort sort);

	
}
