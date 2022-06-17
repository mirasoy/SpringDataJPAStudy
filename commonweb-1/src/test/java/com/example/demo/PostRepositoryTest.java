package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.post.Post;
import com.example.demo.post.PostRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

	@Autowired
	PostRepository postRepository;

	@PersistenceContext
	EntityManager entityManager;

	@Test
	public void save() {

		Post post = new Post();
		post.setTitle("spring title is this!");
		Post savePost = postRepository.save(post);

		assertThat(entityManager.contains(post)).isTrue();
		assertThat(entityManager.contains(savePost)).isTrue();
		assertThat(post == savePost).isTrue();

		Post updatePost = new Post();
		updatePost.setId(savePost.getId());
		updatePost.setTitle("change title");
		Post updatedPost = postRepository.save(updatePost);

		assertThat(entityManager.contains(updatePost)).isFalse();
		assertThat(entityManager.contains(updatedPost)).isTrue();
		assertThat(updatePost == updatedPost).isFalse();

		List<Post> list = postRepository.findAll();
		assertThat(list.size()).isEqualTo(1);

	}

	@Test
	public void findByTitleStartsWith() {

		createPost();
		List<Post> list = postRepository.findByTitleStartsWith("spring");
		assertThat(list.size()).isEqualTo(1);

	}

	@Test
	public void findByTitle() {

		createPost();
		List<Post> list = postRepository.findByTitle("spring title is this!", JpaSort.unsafe("length(title)"));
		assertThat(list.size()).isEqualTo(1);

	}

	@Test
	public void updateTitle() {

		Post post = createPost();
		String newTitle = "update Title";
		int Update = postRepository.updateTitle(newTitle, post.getId());

		assertThat(Update).isEqualTo(1);

		List<Post> list = postRepository.findByTitle(newTitle, JpaSort.unsafe("length(title)"));
		list.forEach(System.out::println);

		assertThat(list.size()).isEqualTo(1);
		assertThat(list.get(0).getTitle()).isEqualTo(newTitle);
	}

	@Test
	public void updateTitle2() {

		Post post = createPost();
		String newTitle = "update Title";
		post.setTitle(newTitle);

		List<Post> list = postRepository.findByTitle(newTitle, JpaSort.unsafe("length(title)"));
		list.forEach(System.out::println);
		assertThat(list.size()).isEqualTo(1);
		assertThat(list.get(0).getTitle()).isEqualTo(newTitle);
	}

	private Post createPost() {
		Post post = new Post();
		post.setTitle("spring title is this!");
		Post savePost = postRepository.save(post);
		return savePost;
	}

}
