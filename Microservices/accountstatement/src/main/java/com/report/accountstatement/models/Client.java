package com.report.accountstatement.models;

/**
 * Model class representing a client, inheriting from Person
 */
public class Client extends Person {
	
	// Unique client ID
	private Long clientId;
 
	// Password for the client's account
	private String password;
	 
	// Status of the client (active/inactive)
	private boolean status;

    // Constructors 
	public Client() {
		super();
	}

	public Client(Long clientId, String password, boolean status) {
		super();
		this.clientId = clientId;
		this.password = password;
		this.status = status;
	}

	// Getters and Setters
	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", password=" + password + ", status=" + status + "]";
	}

}
