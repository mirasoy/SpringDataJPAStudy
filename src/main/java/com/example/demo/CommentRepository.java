package com.example.demo;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepository extends MyRepository<Comment, Long>{
	
	List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String keyword, int likeCount);
	List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCount(String keyword);
	//Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);
	Stream<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);
}
