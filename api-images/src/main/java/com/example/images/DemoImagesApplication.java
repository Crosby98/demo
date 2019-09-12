package com.example.images;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication()
@EnableEurekaClient
@EnableOAuth2Client
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DemoImagesApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoImagesApplication.class, args);
    }
}
