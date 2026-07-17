package com.library.book_manager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**********************************************
 Developer Name: Vikas
 Created on: 17-07-2026 16:34
 Project Name: book-manager ${
 /**********************************************/

@Configuration
public class RestConfiguration
{
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
