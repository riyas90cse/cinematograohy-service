package com.cinematography.api.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.cinematography.api.model.JsonData;

import java.util.Arrays;
import java.util.List;

/**
 * Util Object
 * @author Mohamed Riyas
 */
public class AppUtil {

    /**
     * Static Method to list JsonDataObj
     * Using Object Mapper
     * @param data string
     * @return list of JsonData
     * @throws Exception JsonParsing Exception
     */
    public static List<JsonData> getObject(String data) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonData[] jsonDataArr = objectMapper.readValue(data,JsonData[].class);

        return Arrays.asList(jsonDataArr);
    }
}
