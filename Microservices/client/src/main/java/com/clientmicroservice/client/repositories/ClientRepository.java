package com.clientmicroservice.client.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clientmicroservice.client.entities.Client;

/**
 * Repository interface for Client entity
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
	
	Optional<Client> findTopByOrderByClientIdDesc();
}
