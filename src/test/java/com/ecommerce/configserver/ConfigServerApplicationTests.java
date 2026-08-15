package com.ecommerce.configserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = ConfigServerApplication.class)
class ConfigServerApplicationTests {

    @Autowired
    private EnvironmentRepository environmentRepository;

    @Test
    void contextLoads() {
        assertNotNull(environmentRepository, "EnvironmentRepository should be loaded");
        Environment env = environmentRepository.findOne("catalog-service", "default", "main");
        assertNotNull(env, "Environment for catalog-service should not be null");
    }

}
