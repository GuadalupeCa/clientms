package com.finance.clientms;

import com.finance.clientms.handler.ClientHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration()
public class FunctionalRouter {
    @Bean
    public RouterFunction route(ClientHandler clientHandler) {
        return RouterFunctions
                .route(GET("/client").and(accept(MediaType.APPLICATION_JSON)), clientHandler::findAll)
                .andRoute(GET("/client/ide/{ide}").and(accept(MediaType.APPLICATION_JSON)), clientHandler::findByDocumentIdentityNumber)
                .andRoute(GET("/client/{id}").and(accept(MediaType.APPLICATION_JSON)), clientHandler::findById)
                .andRoute(POST("/client/save").and(accept(MediaType.APPLICATION_JSON)), clientHandler::save)
                .andRoute(PUT("/client/update").and(accept(MediaType.APPLICATION_JSON)), clientHandler::update)
                .andRoute(DELETE("/client/delete/{id}").and(accept(MediaType.APPLICATION_JSON)), clientHandler::deleteById);
    }
}
