package com.cognologix.springboot.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * The type Base initializer.
 */
@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
@Sql({"/data.sql"})
public class BaseInitializer {

    /**
     * The constant container.
     */
    @Container
    public static MySQLContainer container = new MySQLContainer("mysql:8.0")
            .withDatabaseName("test_container_db")
            .withPassword("priyanka")
            .withUsername("priyanka");

    static {
        container.start();
    }

    /**
     * Sets datasource properties.
     *
     * @param registry the registry
     */
    @DynamicPropertySource
    public static void setDatasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }


    /**
     * Test.
     */
    @Test
    public void test() {
        Assert.assertTrue(container.isRunning());
    }

}
