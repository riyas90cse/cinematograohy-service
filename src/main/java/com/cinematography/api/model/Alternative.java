package com.cinematography.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Alternative Object
 * @author Mohamed Riyas
 */
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"quality", "url"})
public class Alternative implements Serializable {

    private final static long serialVersionUID =0L;

    @JsonProperty(value = "quality")
    private String quality;

    @JsonProperty(value = "url")
    private String url;

}
