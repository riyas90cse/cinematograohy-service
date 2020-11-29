package com.mg.api.poc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Gallery Object
 * @author Mohamed Riyas
 */
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"title", "url", "thumbnailUrl", "id"})
public class Gallery implements Serializable {

    private final static long serialVersionUID =0L;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "url")
    private String url;

    @JsonProperty(value = "thumbnailUrl")
    private String thumbnailUrl;

    @JsonProperty(value = "id")
    private String id;


}
