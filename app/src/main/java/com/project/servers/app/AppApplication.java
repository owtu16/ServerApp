package com.project.servers.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.project.servers.app.entity.Server;
import com.project.servers.app.validator.ServerValidator;

//This is the final working version using Thymeleaf
@SpringBootApplication
@PropertySource(value= {"classpath:messages.properties"})
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
//		Server server = new Server("23.23.23.23","Windows","Palo Alto");
//		ServerValidator sv;
//		Boolean isTrue = sv.validateLocation(server.getLocation());
	}

}
