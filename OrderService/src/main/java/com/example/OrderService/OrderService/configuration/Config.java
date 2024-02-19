package com.example.OrderService.OrderService.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sagardas on 19/02/24.
 */
@Configuration
public class Config {

    @Bean
    public RestTemplate restTemplate(){return new RestTemplate();}
}
