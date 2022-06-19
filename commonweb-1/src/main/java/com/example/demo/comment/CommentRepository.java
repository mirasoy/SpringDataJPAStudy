package com.example.demo.comment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	
	@EntityGraph(attributePaths = "post")
	Optional<Comment> findById(Long id);
	
	
	<T> List<T> findByPost_Id(Long postId, Class<T> type);
}
