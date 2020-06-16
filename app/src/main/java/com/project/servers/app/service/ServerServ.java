package com.project.servers.app.service;

import java.util.HashMap;
import java.util.List;

import com.project.servers.app.entity.Server;

public interface ServerServ {

	public List<Server> findAll() throws Exception;
	
	public List<Server> findAllByLocation(String ipAddress) throws Exception;
	
	public HashMap<Server,Long> findByClusters() throws Exception;
		
	public String save() throws Exception;
	
	public String update() throws Exception;
	
	public String delete() throws Exception;
	
}
