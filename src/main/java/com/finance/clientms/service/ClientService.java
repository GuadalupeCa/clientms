package com.finance.clientms.service;

import com.finance.clientms.domain.document.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
    Flux<Client> findAll();
    Mono<Client> findById(String id);
    Mono<Client> save(Client client);
    Mono<Void> deleteById(String id);
    Mono<Client> findByDocumentIdentityNumber(String documentIdentityNumber);
}
