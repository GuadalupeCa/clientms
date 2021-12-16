package com.finance.clientms;

import com.finance.clientms.domain.document.Client;
import com.finance.clientms.handler.ClientHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration()
public class FunctionalRouter {

    @Bean
    @RouterOperations(
            {
                    @RouterOperation(
                            path = "/client",
                            produces = {
                                    MediaType.APPLICATION_JSON_VALUE
                            },
                            method = RequestMethod.GET,
                            beanClass = ClientHandler.class,
                            beanMethod = "findAll",
                            operation = @Operation(
                                    operationId = "findAll",
                                    responses = {
                                            @ApiResponse(
                                                    responseCode = "200",
                                                    description = "successful operation",
                                                    content = @Content(schema = @Schema(
                                                            implementation = Client.class
                                                    ))
                                            )
                                    }
                            )
                    ),
                    @RouterOperation(
                            path = "/client/ide/{ide}",
                            produces = {
                                    MediaType.APPLICATION_JSON_VALUE
                            },
                            method = RequestMethod.GET,
                            beanClass = ClientHandler.class,
                            beanMethod = "findByDocumentIdentityNumber",
                            operation = @Operation(
                                    operationId = "findByDocumentIdentityNumber",
                                    responses = {
                                            @ApiResponse(
                                                    responseCode = "200",
                                                    description = "successful operation",
                                                    content = @Content(schema = @Schema(
                                                            implementation = Client.class
                                                    ))
                                            ),
                                            @ApiResponse(responseCode = "404",description = "customer not found with given id")
                                    },
                                    parameters = {
                                            @Parameter(in = ParameterIn.PATH,name = "ide")
                                    }

                            )

                    ),
                    @RouterOperation(
                            path = "/client/{id}",
                            produces = {
                                    MediaType.APPLICATION_JSON_VALUE
                            },
                            method = RequestMethod.POST,
                            beanClass = ClientHandler.class,
                            beanMethod = "findById",
                            operation = @Operation(
                                    operationId = "findById",
                                    responses = {
                                            @ApiResponse(
                                                    responseCode = "200",
                                                    description = "successful operation",
                                                    content = @Content(schema = @Schema(
                                                            implementation = String.class
                                                    ))
                                            )
                                    },
                                    parameters = {
                                            @Parameter(in = ParameterIn.PATH,name = "id")
                                    }

                            )


                    )
            }
    )
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
