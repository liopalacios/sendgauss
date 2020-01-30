package com.monitorgps.service.sendgauss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SendgaussApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendgaussApplication.class, args);
	}

}
