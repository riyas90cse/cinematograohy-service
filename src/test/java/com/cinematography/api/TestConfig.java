package com.cinematography.api;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Profile("test")
@Configuration
public class TestConfig {

    @Bean
    @Primary
    public RestTemplate getJsonDataService(){
        return Mockito.mock(RestTemplate.class);
    }
}
