package com.ecommerce.project.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI ecommerceOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("E-Commerce REST API")
                        .description("Spring Boot E-Commerce Backend APIs")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Priyam Chakrabarty")
                                .email("priyam.jadavpuruniversity@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Project Documentation"));
    }
}