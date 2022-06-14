package com.example.demo.post;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
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
    public PagedModel<EntityModel<Post>> getAPosts(Pageable pageable, PagedResourcesAssembler<Post> assembler) {
    	return assembler.toModel(postRepository.findAll(pageable));
    }
    
    
}
