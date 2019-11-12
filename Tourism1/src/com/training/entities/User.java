package com.training.entities;

public class User {

	private long id;
	private String userName;
	private String password;
	private String category;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(long id, String userName, String password, String category) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.category = category;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
}
