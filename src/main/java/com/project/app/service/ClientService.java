package com.project.app.service;

import java.util.List;

import com.project.app.entity.Client;

public interface ClientService {
    Client createClient(Client client);
    Client updateClient(Long id, Client client);
    Client getClient(Long id);
    List<Client> getAllClients();
    void deleteClient(Long id);
}
