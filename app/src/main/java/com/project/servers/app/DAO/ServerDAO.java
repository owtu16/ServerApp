package com.project.servers.app.DAO;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.servers.app.entity.Server;

public interface ServerDAO {

	public List<Server> findAllByLocation(Server server);
	
	public List<Server> findAll();
	
	public Server findById(int id);
	
//	public Integer count(Server server);
	
	public HashMap<String, Long> count(int id);
	
	public void save(Server server);
	
	public void deleteById(int id);
	
}
