package com.project.servers.app.DAO;

import com.project.servers.app.entity.User;

public interface LoginDAO {

	String authenticateUser(String username, String password);

	User getUserByUsername(String userUsernameFromDAO);

	

}
