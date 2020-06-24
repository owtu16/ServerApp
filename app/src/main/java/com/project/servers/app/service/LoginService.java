package com.project.servers.app.service;

import com.project.servers.app.entity.User;

public interface LoginService {

	User authenticateUser(String username, String password) throws Exception;

}
