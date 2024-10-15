package com.clientmicroservice.client.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientmicroservice.client.entities.Person;
import com.clientmicroservice.client.repositories.PersonRepository;
import com.clientmicroservice.client.service.PersonService;

import jakarta.transaction.Transactional;

/**
 * Implementation of PersonService
 */
@Service
public class PersonServiceImpl implements PersonService {
	
	// Injecting the PersonRepository dependency
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> getPersonById(String identification) {
        return personRepository.findById(identification);
    }

    @Transactional
    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Transactional
    @Override
    public Person updatePerson(String identification, Person person) {
    	Person updatedPerson = personRepository.findById(identification).orElseThrow();
    	updatedPerson.setName(person.getName());
    	updatedPerson.setGender(person.getGender());
    	updatedPerson.setAge(person.getAge());
    	updatedPerson.setAddress(person.getAddress());
    	updatedPerson.setPhone(person.getPhone());
    	return personRepository.save(updatedPerson);
    }

    @Transactional
    @Override
    public void deletePerson(String identification) {
        personRepository.deleteById(identification);
    }
}
