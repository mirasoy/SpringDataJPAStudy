package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{


	Page<Post> findByTitleContains(String string, PageRequest of);


	Long deleteByTitleContains(String string);

	
}
