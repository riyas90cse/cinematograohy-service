package com.cinematography.api.util;

import lombok.extern.log4j.Log4j2;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

/**
 * Image Cache Listener
 * @author Mohamed Riyas
 */
@Log4j2
public class ImageCacheListener implements CacheEventListener<String, String> {

    /**
     * Void Method
     * to display the logger info of cache events
     * @param cacheEvent params
     */
    @Override
    public void onEvent(CacheEvent<? extends String, ? extends String> cacheEvent) {
        LOG.info("Event '{}' fired for key '{}' with value {}", cacheEvent.getType(), cacheEvent.getKey(), "New Value Executed");
    }
}
