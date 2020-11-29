package com.mg.api.poc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mg.api.poc.model.JsonData;
import com.mg.api.poc.service.JsonDataService;
import com.mg.api.poc.util.AppUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    private static final String URL = "https://mgtechtest.blob.core.windows.net/files/showcase.json";

    private final JsonDataService jsonDataService;


    public JsonDataController(@Autowired JsonDataService jsonDataService) {
        this.jsonDataService = jsonDataService;
    }

    /**
     * Load Data Method
     * @return JsonData List
     * @throws Exception
     */
    @GetMapping(value = "/data/load")
    public ResponseEntity<List<JsonData>> loadData() throws Exception {
        LOG.info("Opening Load Data Method", this.getClass().getSimpleName());
        String data = jsonDataService.loadData();
        List<JsonData> jsonDataList = AppUtil.getObject(data);
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
    @GetMapping(value = "/data/filter")
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
    @GetMapping(value = "/data/{id}")
    public ResponseEntity<JsonData> loadDataById(@PathVariable("id") String id) throws Exception {
        JsonData jsonData = jsonDataService.getDataById(id);
        return new ResponseEntity<>(jsonData, HttpStatus.OK);
    }

    /**
     * Clear Cache Method
     */
    @DeleteMapping("/cache/clear")
    public void clearCache() {
        jsonDataService.clearCache();
    }

}
