package com.example.demo.post;

import org.springframework.context.event.EventListener;

public class PostListener{

//	@EventListener
	public void onApplicationEvent(PostPublishedEvent event) {
		System.out.println("________");
		System.out.println(event.getPost().getTitle() + "___is publicshed!___");
		System.out.println("________");
		
	}
	

}
