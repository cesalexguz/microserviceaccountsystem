package com.clientmicroservice.client.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientmicroservice.client.entities.Client;
import com.clientmicroservice.client.repositories.ClientRepository;
import com.clientmicroservice.client.service.ClientService;

import jakarta.transaction.Transactional;

/**
 * Implementation of ClientService
 */
@Service
public class ClientServiceImpl implements ClientService {
	
	// Injecting the ClientRepository dependency
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(String clientId) {
        return clientRepository.findById(clientId);
    }

    @Transactional
    @Override
    public Client createClient(Client client) {
    	client.setClientId(generateClientId());
        return clientRepository.save(client);
    }

    @Transactional
    @Override
    public Client updateClient(String identification, Client client) {
    	Client updatedClient = clientRepository.findById(identification).orElseThrow();
    	updatedClient.setName(client.getName());
    	updatedClient.setGender(client.getGender());
    	updatedClient.setAge(client.getAge());
    	updatedClient.setAddress(client.getAddress());
    	updatedClient.setPhone(client.getPhone());
    	updatedClient.setClientId(client.getClientId());
    	updatedClient.setPassword(client.getPassword());
    	updatedClient.setStatus(client.isStatus());
    	return clientRepository.save(updatedClient);
    }

    @Transactional
    @Override
    public void deleteClient(String clientId) {
        clientRepository.deleteById(clientId);
    }
    
    public Long generateClientId() {
        Long lastClientId = clientRepository.findTopByOrderByClientIdDesc().map(Client::getClientId).orElse(0L);
        return lastClientId + 1;
    }
}
