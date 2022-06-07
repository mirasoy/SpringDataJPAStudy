package com.example.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.post.PostListener;
import com.example.demo.post.PostPublishedEvent;

@Configuration
public class PostRepositoryTestConfig {

	@Bean
	public  ApplicationListener<PostPublishedEvent> postListenerP(){
		return new ApplicationListener<PostPublishedEvent>() {

			@Override
			public void onApplicationEvent(PostPublishedEvent event) {
				System.out.println("________");
				System.out.println("________");
				System.out.println(event.getPost().getTitle() + "___is publicshed!___");
				System.out.println("________");
				System.out.println("________");
				
			}
			
		};
	}
}
