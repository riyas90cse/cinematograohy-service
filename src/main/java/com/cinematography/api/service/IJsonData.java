package com.cinematography.api.service;

import com.cinematography.api.model.JsonData;

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
   List<JsonData> loadData() throws Exception;

   /**
    * Load Image from cache
    * @param id list of loaded data from rest
    * @return map
    * @throws Exception ex message
    */
   byte[] getImagesUri(String id) throws Exception;

   /**
    * Clear Cache Method
    * To Clear the Cached Data
    */
   void clearCache();
}
