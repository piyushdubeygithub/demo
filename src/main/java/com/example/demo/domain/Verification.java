package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Verification {
	@Id
	Long id;
	
	@Column
	String emailId;
	
	@Column
	String token;
	
	Long userId;

	public Verification() {
	}
	
	public Verification(Long id, String emailId, String token, Long userId) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.token = token;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
