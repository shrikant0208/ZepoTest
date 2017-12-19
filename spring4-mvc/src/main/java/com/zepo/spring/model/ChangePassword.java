package com.zepo.spring.model;

import java.io.Serializable;

public class ChangePassword implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String email;
	String password_old;
	String password_new;
	String password_confirm;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword_old() {
		return password_old;
	}
	public void setPassword_old(String password_old) {
		this.password_old = password_old;
	}
	public String getPassword_new() {
		return password_new;
	}
	public void setPassword_new(String password_new) {
		this.password_new = password_new;
	}
	public String getPassword_confirm() {
		return password_confirm;
	}
	public void setPassword_confirm(String password_confirm) {
		this.password_confirm = password_confirm;
	}
	
	
	
}
