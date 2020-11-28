package com.mg.api.poc.util;

import com.mg.api.poc.model.JsonData;
import lombok.extern.log4j.Log4j2;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

import java.util.List;

@Log4j2
public class DataCacheListener implements CacheEventListener<String, List<JsonData>> {

    @Override
    public void onEvent(CacheEvent<? extends String, ? extends List<JsonData>> cacheEvent) {
        LOG.info("Event '{}' fired for key '{}' with value {}", cacheEvent.getType(), cacheEvent.getKey(), cacheEvent.getNewValue());
    }
}
