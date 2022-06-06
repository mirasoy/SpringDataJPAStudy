package com.example.demo.post;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public class PostCustomRepositoryImpl implements PostCustomRepository {

	@Autowired
	EntityManager entityManager;
	
	
	@Override
	public List<Post> findMyPosts() {
		return entityManager.createQuery("Select p from Post as p", Post.class).getResultList();
	}


	@Override
	public void delete(Post post) {
		System.out.println("custom delete_______");
		entityManager.remove(post);
	}

}
