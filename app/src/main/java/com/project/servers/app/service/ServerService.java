package com.project.servers.app.service;

import java.util.List;
import java.util.Map;

import com.project.servers.app.entity.Server;

public interface ServerService {

	public List<Server> findAllByLocation();
	
	public List<Server> findAll();
	
	public Map<?,?> findKeyValuePairs();
	
	public Integer count();
	
}
