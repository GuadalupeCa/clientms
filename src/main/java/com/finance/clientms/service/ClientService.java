package com.finance.clientms.service;

import com.finance.clientms.entity.Client;
import com.finance.clientms.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Flux<Client> findAll() {
        return clientRepository.findAll();
    }

    public Mono<Client> findById(String id) {
        return clientRepository.findById(id);
    }

    public Mono<Client> save(Client client) {
        return clientRepository.save(client);
    }
    public Mono<Void> deleteById(String id) {
        return clientRepository.deleteById(id);
    }
}