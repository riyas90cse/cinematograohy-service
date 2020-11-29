package com.mg.api.poc.service;

import com.mg.api.poc.model.JsonData;

import java.util.List;

/**
 * Interface JsonData Service
 * @author Mohamed Riyas
 */
public interface IJsonData {

   /**
    * Load Data from Json Method
    * @return String
    */
   String loadData();

   /**
    * Filter Method
    * Get Json Data By filters applicable
    * @param generes filter property
    * @param directors filter property
    * @param rating filter property
    * @param year filter property
    * @return List of Json Data
    */
   List<JsonData> getDataByFilters(String generes, String directors, String rating, String year);

   /**
    * Get Json Data By Id Method
    * Get Details of JsonData By Id as param
    * @param id parameter
    * @return JsonData Object
    */
   JsonData getDataById(String id);

}
