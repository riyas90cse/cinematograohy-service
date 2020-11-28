package com.mg.api.poc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"title", "startDate", "wayToWatch", "endDate"})
public class ViewingWindow implements Serializable {

    private final static long serialVersionUID =0L;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "startDate")
    private Date startDate;

    @JsonProperty(value = "wayToWatch")
    private String wayToWatch;

    @JsonProperty(value = "endDate")
    private Date endDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getWayToWatch() {
        return wayToWatch;
    }

    public void setWayToWatch(String wayToWatch) {
        this.wayToWatch = wayToWatch;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ViewingWindow{" +
                "title='" + title + '\'' +
                ", startDate=" + startDate +
                ", wayToWatch='" + wayToWatch + '\'' +
                ", endDate=" + endDate +
                '}';
    }
}
