package com.cinematography.api.util;

import com.cinematography.api.model.JsonData;
import lombok.extern.log4j.Log4j2;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

import java.util.List;

/**
 * Data Cache Listener
 * @author Mohamed Riyas
 */
@Log4j2
public class DataCacheListener implements CacheEventListener<String, List<JsonData>> {

    /**
     * Void Method
     * to display the logger info of cache events
     * @param cacheEvent params
     */
    @Override
    public void onEvent(CacheEvent<? extends String, ? extends List<JsonData>> cacheEvent) {
        LOG.info("Event '{}' fired for key '{}' with value {}", cacheEvent.getType(), cacheEvent.getKey(), "New Value Executed");
    }

}
