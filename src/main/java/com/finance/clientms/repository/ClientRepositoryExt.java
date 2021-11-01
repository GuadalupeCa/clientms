package com.finance.clientms.repository;

import com.finance.clientms.entity.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientRepositoryExt extends ReactiveMongoRepository<Client, String> {
}
