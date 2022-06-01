package com.cottin.webservice.services;

import java.util.Optional;

import com.cottin.webservice.models.Client;
import com.cottin.webservice.repo.IClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {

    // Attributs
    private final IClientRepository clientRepository;

    // Constructeur
    @Autowired
    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Méthodes

    // Méthode pour récupérer un client avec l'id
    public Client getClient(int id) {
        return clientRepository.findById(id).get();
    }

    // Méthode pour récupérer tous les clients
    public Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Méthode pour récupérer un client avec tous les paramètres
    public Optional<Iterable<Client>> findClientWithAllParams(String lastName, String firstName, String address,
            String city, String zipCode) {
        return clientRepository.findClientWithAllParams(lastName.toLowerCase(), firstName.toLowerCase(),
                address.toLowerCase(), city.toLowerCase(), zipCode.toLowerCase());
    }

}
