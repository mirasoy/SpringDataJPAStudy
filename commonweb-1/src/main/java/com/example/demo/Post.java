package com.example.demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post {

	@Id @GeneratedValue
	private Long id;
	
	private String title;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date  cereate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCereate() {
		return cereate;
	}

	public void setCereate(Date cereate) {
		this.cereate = cereate;
	}
	
	
	
	
}
