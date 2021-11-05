package com.finance.clientms.repository;

import com.finance.clientms.entity.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ClientRepositoryExt extends ReactiveMongoRepository<Client, String> {
    Mono<Client> findByDocumentIdentityNumber(String documentIdentityNumber);
}
