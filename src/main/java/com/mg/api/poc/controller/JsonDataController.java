package com.mg.api.poc.controller;

import com.mg.api.poc.model.Director;
import com.mg.api.poc.model.JsonData;
import com.mg.api.poc.service.JsonDataService;
import com.mg.api.poc.util.AppUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * JsonData Controller
 * @author Mohamed Riyas
 */
@RestController
@Log4j2
public class JsonDataController {

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
     * @param director
     * @param rating
     * @param year
     * @return JsonData List
     * @throws Exception
     */
    @GetMapping(value = "/data/filter")
    public ResponseEntity<List<JsonData>> loadDataByFilter(
            @RequestParam(value = "genres", required = false, defaultValue = "") String generes,
            @RequestParam(value = "director", required = false, defaultValue = "") String director,
            @RequestParam(value = "rating", required = false, defaultValue = "0") Long rating,
            @RequestParam(value = "year", required = false, defaultValue = "") String year
    ) throws Exception {
        List<JsonData> jsonDataList = filterByParams(generes, director, rating, year);
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
        JsonData jsonData = getDetailJsonDataObj(id);
        return new ResponseEntity<>(jsonData, HttpStatus.OK);
    }

    /**
     * Clear Cache Method
     */
    @DeleteMapping("/cache/clear")
    public void clearCache() { jsonDataService.clearCache(); }


    /**
     * Filter By Method
     * Get Json Data By filters applicable
     * @param generes filter property
     * @param director filter property
     * @param rating filter property
     * @param year filter property
     * @return List of Json Data
     */
    private List<JsonData> filterByParams(String genere, String director, Long rating, String year) {
        try {
            String data = jsonDataService.loadData();
            List<JsonData> jsonDataList = AppUtil.getObject(data);
            List<JsonData> response = new ArrayList<>();

            Predicate<String> GENERE = d -> d.equalsIgnoreCase(genere);
            Predicate<JsonData> RATING = d -> d.getRating() == rating;
            Predicate<JsonData> YEAR = d -> d.getYear().equalsIgnoreCase(year);
            Predicate<Director> DIRECTOR = d -> d.getName().equalsIgnoreCase(director);

            if(!StringUtils.isEmpty(genere)) {
                jsonDataList.stream().parallel().forEach(s ->{ Long c = s.getGenres().stream().filter(GENERE).count();
                if(c.longValue() > 0 ) { response.add(s); } });
            }
            if(!StringUtils.isEmpty(director)) {
                jsonDataList.stream().parallel().forEach(s ->{ Long c = s.getDirectors().stream().filter(DIRECTOR).count();
                    if(c.longValue() > 0 ) { response.add(s); } });
            }
            if(rating !=null && rating > 0) {
                jsonDataList.stream().parallel().filter(RATING).collect(Collectors.toList());
                response.addAll(jsonDataList);
            }
            if(!StringUtils.isEmpty(year)) {
                jsonDataList.stream().parallel().filter(YEAR).collect(Collectors.toList());
                response.addAll(jsonDataList);
            }
            return response;
        } catch (Exception e) {
            LOG.info(e.getMessage());
        }
        return new ArrayList<>();
    }

    /**
     * Get Json Data By Id Method
     * Get Details of JsonData By Id as param
     * @param id parameter
     * @return JsonData Object
     */
    private JsonData getDetailJsonDataObj(String id) {
        try {
            String data = jsonDataService.loadData();
            List<JsonData> jsonDataList = AppUtil.getObject(data);
            if(!StringUtils.isEmpty(id)) {
               return jsonDataList.stream().parallel().filter(jsonData -> jsonData.getId().equalsIgnoreCase(id)).findFirst().get();
            }
        } catch (Exception e) {
            LOG.info(e.getMessage());
        }
        return null;
    }

}
