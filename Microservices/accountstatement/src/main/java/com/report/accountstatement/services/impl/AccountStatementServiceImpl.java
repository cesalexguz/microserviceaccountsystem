package com.report.accountstatement.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.accountstatement.models.Account;
import com.report.accountstatement.models.AccountStatement;
import com.report.accountstatement.models.Client;
import com.report.accountstatement.models.Transaction;
import com.report.accountstatement.services.AccountStatementService;
import com.report.accountstatement.services.client.AccountServiceClient;
import com.report.accountstatement.services.client.ClientServiceClient;

/**
 * Implementation of AccountStatementService
 */
@Service
public class AccountStatementServiceImpl implements AccountStatementService {
	
	@Autowired
    private ClientServiceClient clientServiceClient;

    @Autowired
    private AccountServiceClient accountServiceClient;

    @Override
    public AccountStatement getAccountStatement(String clientId, LocalDate startDate, LocalDate endDate) {
        Client client = clientServiceClient.getClientById(clientId);
        List<Account> accounts = accountServiceClient.getAccountsByClientId(clientId);
        List<Transaction> transactions = accountServiceClient.getAllTransactions().stream()
                .filter(transaction -> transaction.getTransactionDate().isAfter(startDate.minusDays(1)) &&
                        transaction.getTransactionDate().isBefore(endDate.plusDays(1)) &&
                        accounts.stream().anyMatch(account -> account.getAccountNumber().equals(transaction.getAccountNumber())))
                .collect(Collectors.toList());;

        AccountStatement accountStatement = new AccountStatement();
        accountStatement.setClient(client);
        accountStatement.setAccounts(accounts);
        accountStatement.setTransactions(transactions);

        return accountStatement;
    }
}
