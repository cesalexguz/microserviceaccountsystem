package com.accountmicroservice.account.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountmicroservice.account.entities.Account;
import com.accountmicroservice.account.repositories.AccountRepository;
import com.accountmicroservice.account.service.AccountService;

import jakarta.transaction.Transactional;

/**
 * Implementation of AccountService
 */
@Service
public class AccountServiceImpl implements AccountService {
	
	// Injecting the AccountRepository dependency
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    
    @Override
    public List<Account> getAllAccountsByClientId(String clientId) {
        return accountRepository.findByClientId(clientId);
    }

    @Override
    public Optional<Account> getAccountById(String accountNumber) {
        return accountRepository.findById(accountNumber);
    }

    @Transactional
    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Transactional
    @Override
    public Account updateAccount(String accountNumber, Account account) {
    	Account updatedAccount = accountRepository.findById(accountNumber).orElseThrow();
    	updatedAccount.setAccountNumber(account.getAccountNumber());
    	updatedAccount.setAccountType(account.getAccountType());
    	updatedAccount.setInitialBalance(account.getInitialBalance());
    	updatedAccount.setStatus(account.isStatus());
    	updatedAccount.setClientId(account.getClientId());
    	return accountRepository.save(updatedAccount);
    }

    @Transactional
    @Override
    public void deleteAccount(String accountNumber) {
        accountRepository.deleteById(accountNumber);
    }
}
