package com.cinematography.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Application Bootstrap
 */
@EnableCaching(proxyTargetClass = true)
@SpringBootApplication
@EnableAsync
public class Cinematography extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Cinematography.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Cinematography.class);
	}

}
