package com.mg.api.poc.service;

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
    * Clear Cache Method
    * To Clear the Cached Data
    */
   void clearCache();
}
