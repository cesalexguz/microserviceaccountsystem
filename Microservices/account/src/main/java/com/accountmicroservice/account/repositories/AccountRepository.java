package com.accountmicroservice.account.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountmicroservice.account.entities.Account;

/*
 * Repository interface for Account entity
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	
	// Method to find accounts by client ID
	List<Account> findByClientId(String clientId);
}
