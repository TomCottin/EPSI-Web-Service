package com.cottin.webservice.services;

import java.util.Optional;

import com.cottin.webservice.models.Client;

public interface IClientService {
    Client getClient(int id);

    Iterable<Client> getAllClients();

    Optional<Iterable<Client>> findClientWithAllParams(String lastName, String firstName, String address, String city, String zipCode);

}
