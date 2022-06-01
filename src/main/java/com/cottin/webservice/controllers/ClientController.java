package com.cottin.webservice.controllers;

import java.util.Optional;

import com.cottin.webservice.models.Client;
import com.cottin.webservice.services.ClientService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    private ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/{id}")
    public Client getClientById(@PathVariable int id) {
        return clientService.getClient(id);
    }

    @GetMapping
    public Optional<Iterable<Client>> getClientByAllParams(
            @RequestParam(required = false, defaultValue = "") String lastName,
            @RequestParam(required = false, defaultValue = "") String firstName,
            @RequestParam(required = false, defaultValue = "") String address,
            @RequestParam(required = false, defaultValue = "") String city,
            @RequestParam(required = false, defaultValue = "") String zipCode) {

        return clientService.findClientWithAllParams(lastName, firstName, address, city, zipCode);
    }

}
