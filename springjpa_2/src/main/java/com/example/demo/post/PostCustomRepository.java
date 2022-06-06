package com.example.demo.post;

import java.util.List;

public interface PostCustomRepository {
	List<Post> findMyPosts();
	void delete(Post post);
}
