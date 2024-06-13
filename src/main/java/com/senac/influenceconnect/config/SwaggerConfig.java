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
		contact.setEmail("ajpf44@gmail.com");
		contact.setName("Alexandre José Ponciano Ferreira");
		contact.setUrl("https://ajpf44.github.io/");
		
//		Contact contact2 = new Contact();
//		contact2.setEmail("deboramat.ipac@gmail.com");
//		contact2.setName("Débora de Oliveira Souza");
//		contact2.setUrl("http://www.aula-teste.com.br");
//		
//		Contact contact3 = new Contact();
//		contact3.setEmail("deboramat.ipac@gmail.com");
//		contact3.setName("Débora de Oliveira Souza");
//		contact3.setUrl("http://www.aula-teste.com.br");
//		
//		Contact contact4 = new Contact();
//		contact4.setEmail("deboramat.ipac@gmail.com");
//		contact4.setName("Débora de Oliveira Souza");
//		contact4.setUrl("http://www.aula-teste.com.br");
//		
//		Contact contact5 = new Contact();
//		contact5.setEmail("deboramat.ipac@gmail.com");
//		contact5.setName("Débora de Oliveira Souza");
//		contact5.setUrl("http://www.aula-teste.com.br");
//		
//		Contact contact6 = new Contact();
//		contact6.setEmail("deboramat.ipac@gmail.com");
//		contact6.setName("Débora de Oliveira Souza");
//		contact6.setUrl("http://www.aula-teste.com.br");
//		
//		Contact contact7 = new Contact();
//		contact7.setEmail("deboramat.ipac@gmail.com");
//		contact7.setName("Débora de Oliveira Souza");
//		contact7.setUrl("http://www.aula-teste.com.br");
//		
//		contacts.addAll(List.of(
//		        contact,
//		        contact2,
//		        contact3,
//		        contact4,
//		        contact5,
//		        contact6,
//		        contact7
//		    ));

		Info info = new Info().title("Documentação API - Aula Teste SENAC Petrópolis").version("1.0.0").contact(contact)
				.description("API com endpoints da Aula Teste.")
				.termsOfService("http://www.aula-teste.com.br/terms");

		return new OpenAPI().info(info).servers(List.of(server));
	}
}


