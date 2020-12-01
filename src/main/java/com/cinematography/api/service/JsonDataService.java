package com.cinematography.api.service;

import com.cinematography.api.model.JsonData;
import com.cinematography.api.util.AppUtil;
import lombok.extern.log4j.Log4j2;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Json Data Service
 *
 * @author Mohamed Riyas
 */
@Service
@Log4j2
public class JsonDataService implements IJsonData {

    private static final String URL = "https://mgtechtest.blob.core.windows.net/files/showcase.json";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Map<String, String> urlMap;

    /**
     * Load Data Method
     * To load the data from the HttpClient URL
     * @return String from the URL by resttempalte
     */
    @Cacheable(value = "jsonData")
    @Override
    public List<JsonData> loadData() throws Exception {
        LOG.info("Retrieving Data from HTTP URL");
        String data = this.restTemplate.getForObject(URL, String.class);
        List<JsonData> jsonDataList = getJsonData(data);

        return jsonDataList;
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Cacheable(value = "imageData")
    @Override
    public byte[] getImagesUri(String id) throws Exception {
        URL url = new URL(urlMap.get(id));
        InputStream in = new BufferedInputStream(url.openStream());
        return FileCopyUtils.copyToByteArray(in);
    }


    /**
     * Clear Cache Method
     */
    @CacheEvict(value = {"jsonData", "imageData"}, allEntries = true)
    @Override
    public void clearCache() {
        LOG.info("Cleared Data cache");
    }

    /**
     * getJsonData Method
     * @param data
     * @return
     * @throws Exception
     */
    private List<JsonData> getJsonData(String data) throws Exception {
        List<JsonData> jsonDataList = AppUtil.getObject(data);

        String localUri = "http://localhost:9000/images/";

        jsonDataList.forEach(jsonData -> {
            if (!StringUtils.isEmpty(jsonData.getUrl())) {
                String id = RandomString.make(5);
                urlMap.put(id, jsonData.getUrl());
                jsonData.setUrl(localUri + id);
            }
            if (!StringUtils.isEmpty(jsonData.getSgUrl())) {
                String id = RandomString.make(5);
                urlMap.put(id, jsonData.getSgUrl());
                jsonData.setSgUrl(localUri + id);
            }
            if (!StringUtils.isEmpty(jsonData.getSkyGoUrl())) {
                String id = RandomString.make(5);
                urlMap.put(id, jsonData.getSkyGoUrl());
                jsonData.setSkyGoUrl(localUri + id);
            }
        });

        jsonDataList.stream().parallel().filter(jsonData -> jsonData.getCardImages() !=null && jsonData.getCardImages().size() > 0)
                .forEach(jsonData -> jsonData.getCardImages().stream().filter(cardImage -> cardImage != null)
                        .forEach(cardImage -> {
                            if (!StringUtils.isEmpty(cardImage.getUrl())) {
                                String id = RandomString.make(5);
                                urlMap.put(id, cardImage.getUrl());
                                cardImage.setUrl(localUri + id);
                            }
                        }));

        jsonDataList.stream().parallel().filter(jsonData -> jsonData.getGalleries() != null && jsonData.getGalleries().size() > 0)
                .forEach(jsonData -> {
                    jsonData.getGalleries().forEach(gallery -> {
                        if (gallery != null) {
                            if (!StringUtils.isEmpty(gallery.getThumbnailUrl())) {
                                String id = RandomString.make(5);
                                urlMap.put(id, gallery.getThumbnailUrl());
                                gallery.setThumbnailUrl(localUri + id);
                            }
                            if (!StringUtils.isEmpty(gallery.getUrl())) {
                                String id = RandomString.make(5);
                                urlMap.put(id, gallery.getUrl());
                                gallery.setUrl(localUri + id);
                            }
                        }
                    });
                });

        jsonDataList.stream().parallel().filter(jsonData -> jsonData.getKeyArtImages() != null && jsonData.getKeyArtImages().size() > 0)
                .forEach(jsonData -> jsonData.getKeyArtImages().forEach(keyArtImage -> {
                    if (keyArtImage != null) {
                        if (!StringUtils.isEmpty(keyArtImage.getUrl())) {
                            String id = RandomString.make(5);
                            urlMap.put(id, keyArtImage.getUrl());
                            keyArtImage.setUrl(localUri + id);
                        }
                    }
                }));

        jsonDataList.stream().parallel().filter(jsonData -> jsonData.getVideos() != null && jsonData.getVideos().size() > 0)
                .forEach(jsonData -> jsonData.getVideos().forEach(video -> {
                    if (video != null) {
                        if (!StringUtils.isEmpty(video.getThumbnailUrl())) {
                            String id = RandomString.make(5);
                            urlMap.put(id, video.getThumbnailUrl());
                            video.setThumbnailUrl(localUri + id);
                        }
                        if (!StringUtils.isEmpty(video.getUrl())) {
                            String id = RandomString.make(5);
                            urlMap.put(id, video.getUrl());
                            video.setUrl(localUri + id);
                        }
                        if (video.getAlternatives() != null && video.getAlternatives().size() > 0) {
                            video.getAlternatives().stream().parallel().forEach(alternative -> {
                                if (alternative != null) {
                                    if (!StringUtils.isEmpty(alternative.getUrl())) {
                                        String id = RandomString.make(5);
                                        urlMap.put(id, alternative.getUrl());
                                        alternative.setUrl(localUri + id);
                                    }
                                }
                            });
                        }
                    }
                }));

        return jsonDataList;
    }
}
