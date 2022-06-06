package com.example.demo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
public class Account {
	
	@Id
	@GeneratedValue //id 자동생성
	private Long id;
	
	@Column(nullable = false, unique = true) //컬럼 제약조건 추가
	private String username ;
	
	private String password ;
	
	@Temporal(TemporalType.TIMESTAMP) //날짜를 자동으로 주입해줌
	private Date created =  new Date();

	
	@OneToMany(mappedBy = "owner")
	Set<Study> studies = new HashSet<Study>();
	
	
	/*
	@Transient // 컬럼으로추가하고 싶지 않은 변수에서 사용
	private String no;

	@Embedded //벨류타입 컬럼 
	@AttributeOverrides({@AttributeOverride(name="street", column=@Column(name = "home_street")) })  //벨류타입 컬럼 커스텀
	private Adress adress ;
	*/
	
	
	public Set<Study> getStudies() {
		return studies;
	}
	public void setStudies(Set<Study> studies) {
		this.studies = studies;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void addStudy(Study study) {
		this.getStudies().add(study);
		study.setOwner(this);
	}
	public void removeStudy(Study study) {
		this.getStudies().remove(study);
		study.setOwner(null);
	}
	
	
		
}
