package com.example.demo.post;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByTitleStartsWith(String string);

	
	@Query("SELECT p FROM #{#entityName} as p WHERE p.title = :title")
	List<Post> findByTitle(@Param("title") String keyword, Sort sort);

	
	@Modifying
	@Query("UPDATE Post p SET p.title = ?1 where id = ?2")
	int updateTitle(String string, Long id);

	
}
