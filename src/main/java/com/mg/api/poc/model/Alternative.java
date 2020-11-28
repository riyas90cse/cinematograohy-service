package com.mg.api.poc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"quality", "url"})
public class Alternative implements Serializable {

    private final static long serialVersionUID =0L;

    @JsonProperty(value = "quality")
    private String quality;

    @JsonProperty(value = "url")
    private String url;


    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Alternative{" +
                "quality='" + quality + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
