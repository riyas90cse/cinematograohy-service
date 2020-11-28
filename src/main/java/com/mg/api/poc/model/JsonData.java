package com.mg.api.poc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    public JsonData() { }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<CardImage> getCardImages() {
        return cardImages;
    }

    public void setCardImages(List<CardImage> cardImages) {
        this.cardImages = cardImages;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public List<Gallery> getGalleries() {
        return galleries;
    }

    public void setGalleries(List<Gallery> galleries) {
        this.galleries = galleries;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<KeyArtImage> getKeyArtImages() {
        return keyArtImages;
    }

    public void setKeyArtImages(List<KeyArtImage> keyArtImages) {
        this.keyArtImages = keyArtImages;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getSgId() {
        return sgId;
    }

    public void setSgId(String sgId) {
        this.sgId = sgId;
    }

    public String getSgUrl() {
        return sgUrl;
    }

    public void setSgUrl(String sgUrl) {
        this.sgUrl = sgUrl;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public String getReviewAuthor() {
        return reviewAuthor;
    }

    public void setReviewAuthor(String reviewAuthor) {
        this.reviewAuthor = reviewAuthor;
    }

    public String getSkyGoId() {
        return skyGoId;
    }

    public void setSkyGoId(String skyGoId) {
        this.skyGoId = skyGoId;
    }

    public String getSkyGoUrl() {
        return skyGoUrl;
    }

    public void setSkyGoUrl(String skyGoUrl) {
        this.skyGoUrl = skyGoUrl;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public ViewingWindow getViewingWindow() {
        return viewingWindow;
    }

    public void setViewingWindow(ViewingWindow viewingWindow) {
        this.viewingWindow = viewingWindow;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "body='" + body + '\'' +
                ", cardImages=" + cardImages +
                ", cast=" + cast +
                ", cert='" + cert + '\'' +
                ", _class='" + _class + '\'' +
                ", directors=" + directors +
                ", duration=" + duration +
                ", galleries=" + galleries +
                ", genres=" + genres +
                ", headline='" + headline + '\'' +
                ", id='" + id + '\'' +
                ", keyArtImages=" + keyArtImages +
                ", lastUpdated=" + lastUpdated +
                ", sgId='" + sgId + '\'' +
                ", sgUrl='" + sgUrl + '\'' +
                ", quote='" + quote + '\'' +
                ", rating=" + rating +
                ", reviewAuthor='" + reviewAuthor + '\'' +
                ", skyGoId='" + skyGoId + '\'' +
                ", skyGoUrl='" + skyGoUrl + '\'' +
                ", sum='" + sum + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", url='" + url + '\'' +
                ", videos=" + videos +
                ", viewingWindow=" + viewingWindow +
                ", year='" + year + '\'' +
                '}';
    }
}
