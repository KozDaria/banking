package com.example.banking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



    @Configuration
    public class MVCConfig implements WebMvcConfigurer {

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/login").setViewName("login");
            registry.addViewController("/registration").setViewName("registration");
            registry.addViewController("/accounts").setViewName("accounts");
            registry.addViewController("/cards").setViewName("cards");
            registry.addViewController("/").setViewName("login");
            registry.addViewController("/welcome").setViewName("welcome");
        }

}
