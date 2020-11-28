package com.mg.api.poc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mg.api.poc.model.JsonData;
import com.mg.api.poc.service.JsonDataService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@Log4j2
public class JsonDataController {

    private static final String url = "https://mgtechtest.blob.core.windows.net/files/showcase.json";

    private final JsonDataService jsonDataService;


    public JsonDataController(@Autowired JsonDataService jsonDataService) {
        this.jsonDataService = jsonDataService;
    }

    @GetMapping(value = "/loadData")
    public ResponseEntity<List<JsonData>> loadData() throws Exception {
        LOG.info("Opening Load Data Method", this.getClass().getSimpleName());
        String data = jsonDataService.loadData(url);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonData[] jsonDataArr = objectMapper.readValue(data,JsonData[].class);
        List<JsonData> jsonDataList = Arrays.asList(jsonDataArr);

        return new ResponseEntity<>(jsonDataList, HttpStatus.OK);
    }

}
