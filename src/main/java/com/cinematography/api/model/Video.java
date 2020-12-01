package com.cinematography.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Video Object
 * @author Mohamed Riyas
 */
@Getter
@Setter
@ToString
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


}
