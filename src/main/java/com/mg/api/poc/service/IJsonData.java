package com.mg.api.poc.service;

import com.mg.api.poc.model.JsonData;

import java.util.List;

public interface IJsonData {

   String loadData(String url);

   List<JsonData> getDataByFilters(String generes, String directors, String rating, String year);

   JsonData getDataById(String id);
}
