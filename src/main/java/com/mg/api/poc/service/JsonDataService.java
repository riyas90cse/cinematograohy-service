package com.mg.api.poc.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JsonDataService implements IJsonData {

    private final RestTemplate restTemplate;

    public JsonDataService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public String loadData(String url) {
        return this.restTemplate.getForObject(url, String.class);
    }

}
