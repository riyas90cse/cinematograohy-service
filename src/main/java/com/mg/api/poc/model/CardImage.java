package com.mg.api.poc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"url", "h", "w"})
public class CardImage implements Serializable {

    private final static long serialVersionUID =0L;

    @JsonProperty(value = "url")
    private String url;

    @JsonProperty(value = "h")
    private long height;

    @JsonProperty(value = "w")
    private long width;

}
