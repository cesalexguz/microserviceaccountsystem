package com.report.accountstatement.services.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.report.accountstatement.models.Client;

@FeignClient(name = "client-service", url = "http://localhost:8081")
public interface ClientServiceClient {

	@GetMapping("/clientes/{id}")
    Client getClientById(@PathVariable("id") String clientId);
}
