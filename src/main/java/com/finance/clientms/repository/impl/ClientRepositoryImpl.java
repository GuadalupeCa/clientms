package com.finance.clientms.repository.impl;

import com.finance.clientms.entity.Client;
import com.finance.clientms.repository.ClientRepositoryExt;
import com.finance.clientms.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    @Autowired
    private ClientRepositoryExt clientRepository;

    @Override
    public Flux<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Mono<Client> findById(String id) {
        return clientRepository.findById(id);
    }

    @Override
    public Mono<Client> save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return clientRepository.deleteById(id);
    }

    @Override
    public Mono<Client> findByDocumentIdentityNumber(String documentIdentityNumber) {
        return clientRepository.findByDocumentIdentityNumber(documentIdentityNumber);
    }
}
