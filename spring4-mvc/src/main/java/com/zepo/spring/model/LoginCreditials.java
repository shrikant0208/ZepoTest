package com.zepo.spring.model;

import java.io.Serializable;

public class LoginCreditials implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String email;
	String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
