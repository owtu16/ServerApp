package com.project.servers.app.DAO;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.servers.app.entity.Server;

public interface ServerDAO {

	public List<Server> findAllByLocation(String location);
	
	public List<Server> findAll();
	
	public Server findById(int id);
	
//	public Integer count(Server server);
	
	public HashMap<String, Long> count(int id); // might use later
	
	public void save(Server server);
	
	public void deleteById(int id);
	
	public void delete(String ipAddress); // delete by passing ip address

	public List<Server> findByLocation();

	public void update(Server server);
	
}
