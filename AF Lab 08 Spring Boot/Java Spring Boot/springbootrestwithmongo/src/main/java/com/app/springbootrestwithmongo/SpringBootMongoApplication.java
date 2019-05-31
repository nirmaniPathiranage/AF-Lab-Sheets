package com.app.springbootrestwithmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories({"com.app.springbootrestwithmongo.service"})
public class SpringBootMongoApplication extends SpringBootServletInitializer {
	
	public static void main(String args[]) {
		SpringApplication.run(SpringBootMongoApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(SpringBootMongoApplication.class);
	}
	

}
