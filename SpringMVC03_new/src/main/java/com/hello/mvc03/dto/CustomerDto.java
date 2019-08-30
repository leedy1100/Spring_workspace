package com.hello.mvc03.dto;

public class CustomerDto {

	private String id;
	private String name;
	private String password;

	public CustomerDto() {

	}

	public CustomerDto(String id, String name, String passoword) {
		this.id = id;
		this.name = name;
		this.password = passoword;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
