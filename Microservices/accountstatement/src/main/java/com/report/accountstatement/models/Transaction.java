package com.report.accountstatement.models;

import java.time.LocalDate;

public class Transaction {
	
	// Unique transaction ID
	private Long id;
	 
	// Date of the transaction
	private LocalDate transactionDate;
	 
	// Type of the transaction (e.g., deposit, withdrawal)
	private String transactionType;
	 
	// Amount involved in the transaction
	private double amount;
	 
	// Balance after the transaction
	private double balance;
	 
	// Account number associated with the transaction
	private String accountNumber;

    // Constructors 
	public Transaction() {
		super();
	}

	public Transaction(Long id, LocalDate transactionDate, String transactionType, double amount, double balance,
			String accountNumber) {
		super();
		this.id = id;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.amount = amount;
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transactionDate=" + transactionDate + ", transactionType=" + transactionType
				+ ", amount=" + amount + ", balance=" + balance + ", accountNumber=" + accountNumber + "]";
	}

}
