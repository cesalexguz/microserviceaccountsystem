package com.clientmicroservice.client.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientmicroservice.client.entities.Person;
import com.clientmicroservice.client.service.impl.PersonServiceImpl;

/**
 * REST controller for managing persons
 */
@RestController
@RequestMapping("/personas")
public class PersonController {

	// Injecting the personService implementation
    @Autowired
    private PersonServiceImpl personService;

    // Endpoint to retrieve all persons
    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
    	 return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }
    
    // Endpoint to retrieve a person by their ID
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") String id) {
        Optional<Person> person = personService.getPersonById(id);
        if(person.isPresent()) {
            return new ResponseEntity<>(person.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint to create a new person
    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody Person person) {
    	try {
    		Person savedPerson = personService.createPerson(person);
            return new ResponseEntity<>(savedPerson, HttpStatus.OK);

        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Data integrity violation: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (TransactionSystemException e) {
            return new ResponseEntity<>("Transaction system exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint to update an existing person by their ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable("id") String id, @RequestBody Person personDetails) {
    	try {
    		Person updatedPerson = personService.updatePerson(id, personDetails);
            return new ResponseEntity<>(updatedPerson, HttpStatus.OK);

        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Data integrity violation: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (TransactionSystemException e) {
            return new ResponseEntity<>("Transaction system exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint to delete a person by their ID
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") String id) {
        personService.deletePerson(id);
    }
}
