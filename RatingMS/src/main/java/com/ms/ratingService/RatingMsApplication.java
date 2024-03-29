package com.ms.ratingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RatingMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingMsApplication.class, args);
	}

}
