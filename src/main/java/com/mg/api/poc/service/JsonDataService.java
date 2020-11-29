package com.mg.api.poc.service;

import com.mg.api.poc.model.JsonData;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Json Data Service
 * @author Mohamed Riyas
 */
@Service
@Log4j2
public class JsonDataService implements IJsonData {

    private final RestTemplate restTemplate;

    public JsonDataService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * Load Data Method
     * To load the data from the HttpClient URL
     * @param url HTTP client URL
     * @return String from the URL by resttempalte
     */
    @Cacheable(value = "jsonData")
    @Override
    public String loadData(String url) {
        LOG.info("Retrieving Data from HTTP URL");
        return this.restTemplate.getForObject(url, String.class);
    }

    /**
     * Load Data By Filters Method
     * To load the data by using the applicable filters
     * @param generes property
     * @param directors property
     * @param rating property
     * @param year property
     * @return List of Json Data
     */
    @Override
    public List<JsonData> getDataByFilters(String generes, String directors, String rating, String year) {
        List<JsonData> jsonDataList = new ArrayList<>();
        return jsonDataList;
    }

    /**
     * Load Data By Id Method
     * To load the detail data of JsonData Obj by Id
     * @param id property
     * @return JsonData Object
     */
    @Override
    public JsonData getDataById(String id) {
        JsonData jsonData = new JsonData();
        return jsonData;
    }

    /**
     * Clear Cache Method
     */
    @CacheEvict(value = "jsonData", allEntries = true)
    public void clearCache() {
        LOG.info("Cleared Data cache");
    }

}
