package com.mg.api.poc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"type", "title", "type", "alternatives", "thumbnailUrl", "url"})
public class Video implements Serializable {

    private final static long serialVersionUID =0L;

    @JsonProperty(value = "type")
    private String type;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "alternatives")
    private List<Alternative> alternatives;

    @JsonProperty(value = "thumbnailUrl")
    private String thumbnailUrl;

    @JsonProperty(value = "url")
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Alternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<Alternative> alternatives) {
        this.alternatives = alternatives;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Video{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", alternatives=" + alternatives +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
