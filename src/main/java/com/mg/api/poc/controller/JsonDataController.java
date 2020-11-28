package com.mg.api.poc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mg.api.poc.model.JsonData;
import com.mg.api.poc.service.JsonDataService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JsonData Controller
 * @author Mohamed Riyas
 */
@RestController
@Log4j2
public class JsonDataController {

    private static final String url = "https://mgtechtest.blob.core.windows.net/files/showcase.json";

    private final JsonDataService jsonDataService;


    public JsonDataController(@Autowired JsonDataService jsonDataService) {
        this.jsonDataService = jsonDataService;
    }

    /**
     * Load Data Method
     * @return JsonData List
     * @throws Exception
     */
    @GetMapping(value = "/loadData")
    public ResponseEntity<List<JsonData>> loadData() throws Exception {
        LOG.info("Opening Load Data Method", this.getClass().getSimpleName());
        String data = jsonDataService.loadData(url);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonData[] jsonDataArr = objectMapper.readValue(data,JsonData[].class);
        List<JsonData> jsonDataList = Arrays.asList(jsonDataArr);

        return new ResponseEntity<>(jsonDataList, HttpStatus.OK);
    }

    /**
     * Load Json Data By Filter Method
     * @param generes
     * @param directors
     * @param rating
     * @param year
     * @return JsonData List
     * @throws Exception
     */
    @GetMapping(value = "/loadDataByFilter")
    public ResponseEntity<List<JsonData>> loadDataByFilter(
            @RequestParam(value = "genres", required = false, defaultValue = "") String generes,
            @RequestParam(value = "directors", required = false, defaultValue = "") String directors,
            @RequestParam(value = "rating", required = false, defaultValue = "") String rating,
            @RequestParam(value = "year", required = false, defaultValue = "") String year
    ) throws Exception {
        List<JsonData> jsonDataList = jsonDataService.getDataByFilters(generes, directors, rating, year);
        return new ResponseEntity<>(jsonDataList, HttpStatus.OK);
    }

    /**
     * Load Json Data By Id Method
     * To view details object of the JsonData by Id
     * @param id
     * @return JsonData
     * @throws Exception
     */
    @GetMapping(value = "/loadDataById")
    public ResponseEntity<JsonData> loadDataById(@RequestParam(value = "id") String id) throws Exception {
        JsonData jsonData = jsonDataService.getDataById(id);
        return new ResponseEntity<>(jsonData, HttpStatus.OK);
    }

    /**
     * Clear Cache Method
     */
    @DeleteMapping("/clearCache")
    public void clearCache() {
        jsonDataService.clearCache();
    }

}
