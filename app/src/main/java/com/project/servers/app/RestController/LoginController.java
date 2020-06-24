package com.project.servers.app.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.servers.app.entity.User;
import com.project.servers.app.service.LoginService;
import com.project.servers.app.utility.HashingUtility;

@RestController
@RequestMapping("/serverAPI")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private Environment environment;
	
	static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	@PostMapping("/login")
	public ResponseEntity<User> authenticateUser(@RequestBody User user) throws Exception{
		try {
			logger.info("USER TRYING TO LOGIN, VALIDATING CREDENTIALS: " + user.getUsername());
			User userFromDb = loginService.authenticateUser(user.getUsername(), HashingUtility.getHashValue(user.getPassword()));
			
			logger.info("USER LOGIN SUCCESS, USERNAME: " + user.getUsername());
			return new ResponseEntity<User>(userFromDb, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,environment.getProperty(e.getMessage()));
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
