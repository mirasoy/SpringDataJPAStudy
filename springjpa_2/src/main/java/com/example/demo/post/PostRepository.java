package com.example.demo.post;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.MyRepository;

public interface PostRepository extends MyRepository<Post, Long> {


}
