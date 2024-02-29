package com.rmrdo.notsimpleboardproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NotSimpleBoardProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotSimpleBoardProjectApplication.class, args);
	}

}
