package com.senac.influenceconnect.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Value("${prop.swagger.dev-url}")
	private String devUrl;

	@Bean
	OpenAPI myOpenAPI() {
		Server server = new Server();
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		server.setUrl(devUrl);
		server.setDescription("Server URL - ambiente de desenvolvimento");

		Contact contact = new Contact();
		contact.setEmail("petropolis@rj.senac.br");
		contact.setName("Grupo Influence Connect");
		contact.setUrl("https://github.com/InfluenceConnect/back");

		Info info = new Info().title("Documentação API - Info 4 -Influence Connect").version("1.0.0").contact(contact)
				.description("API com endpoints do backend do projeto Influence Connect.")
				.termsOfService("https://github.com/InfluenceConnect/back/blob/main/LICENSE");

		return new OpenAPI().info(info).servers(List.of(server));
	}
}


