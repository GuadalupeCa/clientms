package com.finance.clientms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Flux;

@EnableMongoRepositories
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		Flux<String> flux = Flux.just("x", "y", "z");
////		Flux<String> flux = Flux.fromArray(new String[]{"x", "y", "z"});
////		Flux<String> flux = Flux.fromIterable(Arrays.asList("x", "y", "z"));
//
//// To subscribe, call the method
//
//		flux.subscribe(p -> System.out.println(p.toString()));
	}



}
