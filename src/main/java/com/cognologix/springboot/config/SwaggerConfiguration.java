/*******************************************************************************
 * Copyright (C) 2021
 ******************************************************************************/
package com.cognologix.springboot.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger configuration.
 *
 * @author Priyanka Hatgine
 */
@Configuration
public class SwaggerConfiguration {
    /**
     * Spring shop open api open api.
     *
     * @return the open api
     */
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Spring Boot Banking Application")
                        .description("Spring boot demo application")
                        .version("v1.0.0")
                        .license(new License().name("License").url("https://cognologix.com/")))
                .externalDocs(new ExternalDocumentation()
                        .description("Spring Boot Demo Wiki Documentation")
                        .url("https://cognologix.com/"));
    }
}
