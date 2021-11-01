package com.finance.clientms.handler;

import com.finance.clientms.entity.Client;
import com.finance.clientms.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ClientHandler {
    @Autowired
    private ClientService clientService;

    public Mono findAll(ServerRequest serverRequest) {
        log.info("Find all clients");
        return ServerResponse.ok()
                .body(clientService.findAll(), Client.class);
    }

    public Mono findById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        log.info("Find by Id: {}", id);
        return ServerResponse.ok()
                .body(clientService.findById(id), Client.class);
    }

    public Mono save(ServerRequest serverRequest) {
        Mono<Client> client = serverRequest.bodyToMono(Client.class);
        log.info("Save client");
        return client.flatMap(c -> ServerResponse
                .status(HttpStatus.CREATED)
                .body(clientService.save(c), Client.class));
    }

    public Mono update(ServerRequest serverRequest) {
        Mono<Client> client = serverRequest.bodyToMono(Client.class);
        log.info("Update client");
        return client.flatMap(c -> ServerResponse
                .status(HttpStatus.CREATED)
                .body(clientService.save(c), Client.class));
    }

    public Mono deleteById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        log.info("Delete client");
        return clientService.deleteById(id).then(ServerResponse.noContent().build());
    }
}
