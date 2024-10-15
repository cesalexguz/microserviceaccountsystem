package com.report.accountstatement.models;

/**
 * Model class representing a bank account
 */
public class Account {
	
	// Unique account number
	private String accountNumber;
	 
	// Type of the account (e.g., savings, checking)
	private String accountType;
	 
	// Initial balance of the account
	private double initialBalance;
	 
	// Status of the account (active/inactive)
	private boolean status;
	 
	// ID of the client who owns the account
	private String clientId;

    // Constructors 
	public Account() {
		super();
	}

	public Account(String accountNumber, String accountType, double initialBalance, boolean status, String clientId) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.initialBalance = initialBalance;
		this.status = status;
		this.clientId = clientId;
	}

	// Getters and Setters
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", initialBalance="
				+ initialBalance + ", status=" + status + ", clientId=" + clientId + "]";
	}

}