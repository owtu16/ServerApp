package com.project.servers.service;


import java.util.List;

import com.project.servers.model.Server;

public interface ServerService {
	
	public List<Server> getServerDetails() throws Exception;

	
}