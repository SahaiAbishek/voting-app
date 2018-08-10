package com.test.voting.model;

public class Vote {
	private String userName;
	private String email;
	private String candidate;

	public Vote() {
		super();
	}

	public Vote(String userName, String email, String candidate) {
		super();
		this.userName = userName;
		this.email = email;
		this.candidate = candidate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCandidate() {
		return candidate;
	}

	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}
}
