package com.sheetal.sheetal_springboot_project.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${sandbox-url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("info@codetalksdna.com");
        contact.setName("CodeTalksDNA");
        contact.setUrl("https://www.codetalksdna.com");

        License mitLicense = new License().name("CodeTalksDNA License").url("https://codetalksdna.com/");

        Info info = new Info()
                .title("Sheetal Management API Endpoints")
                .version("2.0")
                .contact(contact)
                .description("This API Exposes Taught During the Spring Boot Session.").termsOfService("https://www.codetalksdna.com/terms")
                .license(mitLicense);
        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
