package com.apiux.tasklists.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // .allowedOrigins("http://localhost:4200")
                .allowedOrigins("http://ec2-18-217-92-102.us-east-2.compute.amazonaws.com/")
                .allowedMethods("GET")
                .allowedMethods("POST");
    }
}