package com.example.banking;

import com.example.banking.model.dto.UserDto;
import com.example.banking.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@PropertySource(value="classpath:application.yaml")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BankingApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankingApplication.class, args);
	}
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/templates/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
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
