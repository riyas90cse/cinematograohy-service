package com.mg.api.poc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * JsonData Object
 * @author Mohamed Riyas
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"body", "cardImages", "cast", "cert", "class", "directors", "duration", "galleries", "genres", "headline",
        "id", "keyArtImages", "lastUpdated", "sgid", "sgUrl", "quote", "rating", "reviewAuthor", "skyGoId", "skyGoUrl", "sum", "synopsis",
        "url", "videos", "viewingWindow", "year"
})
public class JsonData implements Serializable {

    private final static long serialVersionUID =0L;

    @JsonProperty(value = "body")
    private String body;

    @JsonProperty(value = "cardImages")
    private List<CardImage> cardImages;

    @JsonProperty(value = "cast")
    private List<Cast> cast;

    @JsonProperty(value = "cert")
    private String cert;

    @JsonProperty(value = "class")
    private String _class;

    @JsonProperty(value = "directors")
    private List<Director> directors;

    @JsonProperty(value = "duration")
    private long duration;

    @JsonProperty(value = "galleries")
    private List<Gallery> galleries;

    @JsonProperty(value = "genres")
    private List<String> genres;

    @JsonProperty(value = "headline")
    private String headline;

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "keyArtImages")
    private List<KeyArtImage> keyArtImages;

    @JsonProperty(value = "lastUpdated")
    private Date lastUpdated;

    @JsonProperty(value = "sgid")
    private String sgId;

    @JsonProperty(value = "sgUrl")
    private String sgUrl;

    @JsonProperty(value = "quote")
    private String quote;

    @JsonProperty(value = "rating")
    private long rating;

    @JsonProperty(value = "reviewAuthor")
    private String reviewAuthor;

    @JsonProperty(value = "skyGoId")
    private String skyGoId;

    @JsonProperty(value = "skyGoUrl")
    private String skyGoUrl;

    @JsonProperty(value = "sum")
    private String sum;

    @JsonProperty(value = "synopsis")
    private String synopsis;

    @JsonProperty(value = "url")
    private String url;

    @JsonProperty(value = "videos")
    private List<Video> videos;

    @JsonProperty(value = "viewingWindow")
    private ViewingWindow viewingWindow;

    @JsonProperty(value = "year")
    private String year;

}
