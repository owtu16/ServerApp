package com.project.servers.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.servers.app.DAO.LoginDAO;
import com.project.servers.app.entity.User;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO loginDAO;
	
	@Override
	public User authenticateUser(String username, String password) throws Exception {
		User user = null;
		String userUsernameFromDAO = loginDAO.authenticateUser(username.toLowerCase(),password);
		if(userUsernameFromDAO != null) {
			user = loginDAO.getUserByUsername(userUsernameFromDAO);
			
		}
		else {
			throw new Exception("LoginService.INVALID_CREDENTIALS");
		}
		return user;
	}

}
