package com.mg.api.poc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Cast Object
 * @author Mohamed Riyas
 */
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name"})
public class Cast implements Serializable {

    private final static long serialVersionUID =0L;

    @JsonProperty(value = "name")
    private String name;

}
