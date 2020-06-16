package com.project.servers.app.service;

import java.util.HashMap;
import java.util.List;

import com.project.servers.app.entity.Server;

public interface ServerServ {

	public void save(Server server) throws Exception;
	
	public void update(Server server) throws Exception;
	
	public void delete(String ipAddress) throws Exception;
	
	public List<Server> findAll() throws Exception;
	
	public HashMap<Server,Long> findByClusters() throws Exception;
	
	public Server findByIpAddress(String ipAddress) throws Exception;
	
	public List<Server> findAllByLocation(String ipAddress) throws Exception;
	
	
		
}
