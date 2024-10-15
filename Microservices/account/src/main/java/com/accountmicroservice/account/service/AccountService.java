package com.accountmicroservice.account.service;

import java.util.List;
import java.util.Optional;

import com.accountmicroservice.account.entities.Account;

/**
 * Service interface for managing accounts
 */
public interface AccountService {
	
	// Retrieve all accounts
	List<Account> getAllAccounts();
	
	// Retrieve all accounts using client id
	List<Account> getAllAccountsByClientId(String clientId);
	
	// Retrieve an account by its number
	Optional<Account> getAccountById(String accountNumber);
	 
	// Create a new account
	Account createAccount(Account account);
	 
	// Update an existing account by its number
	Account updateAccount(String accountNumber, Account account);
	 
	// Delete an account by its number
	void deleteAccount(String accountNumber);
	
}
