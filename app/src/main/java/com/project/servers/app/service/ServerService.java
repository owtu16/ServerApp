package com.project.servers.app.service;

import java.util.List;
import java.util.Map;

import com.project.servers.app.entity.Server;

public interface ServerService {

	public List<Server> findAllByLocation(Server server);
	
	public List<Server> findAll();
	
	public Integer count(Server server);
	
	public void save(Server server);
	
	public void deleteById(int id);
	
}
