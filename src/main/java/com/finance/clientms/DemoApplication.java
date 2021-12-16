package com.finance.clientms;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@EnableEurekaClient
//@EnableDiscoveryClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Spring WebFlux api client",
		description = "End points client Microservice"
))
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

//
//
//		Flux.fromArray(new String[]{"blue", "green", "orange", "purple"})
//				.doOnNext(System.out::println)
//				.map(String::toUpperCase)
//				.doOnNext(System.out::println);
//
//		Flux.fromArray(new String[]{"blue", "green", "orange", "purple"})
//				.doOnNext(System.out::println)
//				.as(String::toUpperCase)
//				.doOnNext(System.out::println);
	}
}
