package com.example.banking;

import com.example.banking.model.dto.UserDto;
import com.example.banking.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;

@PropertySource(value="classpath:application.yaml")
@SpringBootApplication
public class BankingApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankingApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner run(UserService userService) {
//		return args -> {
//
//			userService.create(new UserDto("Elena", "Petrova", "elena@Petrova.com", "lenPe","1234","89214563212"));
//
//		};
//	}

}
