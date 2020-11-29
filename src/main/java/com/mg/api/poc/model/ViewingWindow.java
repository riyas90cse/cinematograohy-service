package com.mg.api.poc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * ViewingWindow Object
 * @author Mohamed Riyas
 */
@Getter
@Setter
@ToString
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

}
