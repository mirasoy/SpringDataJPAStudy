package com.example.demo.comment;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommnetRepository extends JpaRepository<Commnet, Long> {

	
	@EntityGraph(attributePaths = "post")
	Optional<Commnet> findById(Long id);
}
