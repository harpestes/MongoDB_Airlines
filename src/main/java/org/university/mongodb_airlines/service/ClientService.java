package org.university.mongodb_airlines.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.university.mongodb_airlines.entity.Client;
import org.university.mongodb_airlines.repository.ClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client createClient(Client client) {
        if (!clientRepository.existsByFullName(client.getFullName())) {
            return clientRepository.save(client);
        }
        throw new IllegalArgumentException("Client already exists");
    }

    public Client getClientById(String id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client updateClient(Client client) {
        if (!clientRepository.existsById(client.getId())) {
            throw new IllegalArgumentException("Client not exists");
        }
        return clientRepository.save(client);
    }

    public void deleteClient(String id) {
        clientRepository.deleteById(id);
    }
}
