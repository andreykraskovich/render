package com.example.render.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Рендер ферма",
                version = "1.0",
                contact = @Contact(
                        email = "gemius99@gmail.com"
                )
        )
)
@Configuration
public class SwaggerConfig {
}
