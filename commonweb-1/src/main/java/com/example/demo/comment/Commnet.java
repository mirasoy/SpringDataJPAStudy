package com.example.demo.comment;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;

import com.example.demo.post.Post;

@Entity
//@NamedEntityGraph(name = "Commnet.post", attributeNodes = @NamedAttributeNode("post"))
public class Commnet {

	@Id @GeneratedValue
	private Long id;
	
	private String commnet;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Post post;
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommnet() {
		return commnet;
	}

	public void setCommnet(String commnet) {
		this.commnet = commnet;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Commnet [id=" + id + ", commnet=" + commnet + ", post=" + post + "]";
	}
	
	
	
}
