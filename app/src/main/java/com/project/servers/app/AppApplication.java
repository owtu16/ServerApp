package com.project.servers.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.project.servers.app.DAO.ServerDAO;
import com.project.servers.app.entity.Server;
import com.project.servers.app.service.ServerService;
import com.project.servers.app.validator.ServerValidator;

//This is the final working version using Thymeleaf
@SpringBootApplication
@PropertySource(value= {"classpath:messages.properties"})
public class AppApplication {
	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppApplication.class, args);
		
	}

}
