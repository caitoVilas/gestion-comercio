package com.trade.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author claudio.vilas
 * date 09/2023
 */

@Configuration
public class SwaggerConfig {
        @Value("${application.version}")
        private String version;
        @Bean
        public GroupedOpenApi openApi(){
            return GroupedOpenApi.builder()
                    .group("comercio")
                    .packagesToScan("com.trade")
                    .build();
        }

        @Bean
        public OpenAPI openAPI(){
            return new OpenAPI()
                    .info(new Info().title("Gestion Comercio")
                            .description("Sistema de Gestion Comercial")
                            .contact(new Contact().name("caito").email("caitocd@gmail.com"))
                            .version(version));
        }
}
