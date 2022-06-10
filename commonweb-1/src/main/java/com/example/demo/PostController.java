package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	@Autowired
	private  PostRepository postRepository;
	
	
	
    @GetMapping("/posts/{id}")
    public String getAPost(@PathVariable("id") Post post) {
//        Optional<Post> byId = postRepository.findById(id);
//        Post post = byId.get();
        return post.getTitle();
    }

	
    @GetMapping("/posts")
    public Page<Post> getAPosts(Pageable pageable) {
    	return postRepository.findAll(pageable);
    }
    
    
}
