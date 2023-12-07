package com.example.mongoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MongoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoServiceApplication.class, args);
	}

}
