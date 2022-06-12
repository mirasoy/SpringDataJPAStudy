package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

	@Autowired
	MockMvc mvc;

	@Autowired
	PostRepository postRepository;

	@Test
	public void getPost() throws Exception {
		Post post = new Post();
		post.setTitle("spring title is this!");
		postRepository.save(post);
		mvc.perform(get("/posts/" + post.getId())).andDo(print()).andExpect(status().isOk());
	}
	
	
	
	@Test
	public void getPosts() throws Exception {
		createPost();
		
		mvc.perform(get("/posts")
		.param("page","2")
		.param("size","10")
		.param("sort","title")
		).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.content[0].title", is("pring title is this")));
	}



	private void createPost() {
		int postCount  = 100;
		while(postCount > 0 ) {
			
			Post post2 = new Post();
			post2.setTitle("pring title is this! >"+postCount);
			postRepository.save(post2);
			postCount--;
		}
	}
}
