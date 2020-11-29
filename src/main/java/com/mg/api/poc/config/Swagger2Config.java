package com.mg.api.poc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Swagger Configuration Configuration
 * @author Mohamed Riyas
 */
@Configuration
@EnableSwagger2
public class Swagger2Config implements AbstractSwaggerConfig {

    /**
     * @return docket
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(Collections.singletonList(apiKey()))
                .securityContexts(Collections.singletonList(securityContext()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mg.api.poc"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    /**
     * @return api key
     */
    @Bean
    public ApiKey apiKey() { return new ApiKey("Bearer", "Authorization", "header"); }

    /**
     * Meta Data Method
     * @return apiinfo
     */
    @Override
    public ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("MG POC REST API")
                .description("API Specification For MG POC APPLICATION")
                .contact(new Contact("Mohamed Riyas", "https://example.com", "riyas90cse@gmail.com"))
                .license("Open Source")
                .licenseUrl(null)
                .version("1.0.0")
                .build();
    }

}
