package com.mg.api.poc.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mg.api.poc.model.JsonData;

import java.util.Arrays;
import java.util.List;

public class AppUtil {

    public static List<JsonData> getObject(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonData[] jsonDataArr = objectMapper.readValue(data,JsonData[].class);

        return Arrays.asList(jsonDataArr);
    }
}
