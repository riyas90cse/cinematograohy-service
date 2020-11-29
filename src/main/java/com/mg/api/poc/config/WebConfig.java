package com.mg.api.poc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web Configuration to handle Cors Mapping
 * @author Mohamed Riyas
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * cors mapping method
     * @param registry cors registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(Boolean.TRUE)
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders(
                        "Access-Control-Allow-Headers",
                        "Access-Control-Expose-Headers",
                        "Access-Control-Allow-Origin",
                        "Access-Control-Request-Method",
                        "Access-Control-Request-Headers",
                        "Origin",
                        "Cache-Control",
                        "Content-Type",
                        "Authorization")
                .exposedHeaders("Authorization");
    }
}
