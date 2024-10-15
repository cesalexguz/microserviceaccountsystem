package com.clientmicroservice.client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clientmicroservice.client.entities.Person;

/**
 * Repository interface for Person entity
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
}
