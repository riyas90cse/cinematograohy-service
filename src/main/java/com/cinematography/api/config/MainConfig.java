package com.cinematography.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

/**
 * Main Configuration File to Override the ThreadPool Task Executor
 * @author Mohamed Riyas
 */
@Configuration
public class MainConfig {

    /**
     * Async Executor to over ride the thread pool task execution
     * @return thread pool task
     */
    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(7);
        executor.setMaxPoolSize(42);
        executor.setQueueCapacity(11);
        executor.setThreadNamePrefix("mgpoc-api-");
        return executor;
    }

    /**
     * RestTemplate Bean Registration
     * @return RestTempalte
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
