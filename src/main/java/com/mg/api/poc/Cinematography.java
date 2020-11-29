package com.mg.api.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Application Bootstrap
 */
@EnableCaching(proxyTargetClass = true)
@SpringBootApplication
public class Cinematography {

	public static void main(String[] args) {
		SpringApplication.run(Cinematography.class, args);
	}

}
