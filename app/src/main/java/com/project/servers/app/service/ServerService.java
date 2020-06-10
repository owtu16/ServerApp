package com.project.servers.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.servers.app.entity.Server;

public interface ServerService {

	public List<Server> findAllByLocation(String location);
	
	public List<Server> findAll();
	
	public Server findById(int id);
	
//	public Integer count(Server server);
	
	public HashMap<String, Long> count(int id);
	
	public void save(Server server);
	
	public void deleteById(int id);

	public List<Server> findByLocation();
	
}
