package com.optimization.hosting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.optimization.hosting.repository", "com.optimization.hosting.service", "com.optimization.hosting.controller" })
@EntityScan("com.optimization.hosting.model")
@EnableJpaRepositories("com.optimization.hosting.repository")
public class OptimizationHostingApplication {

    private static final Logger logger = LoggerFactory.getLogger(OptimizationHostingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OptimizationHostingApplication.class, args);
    }
}

