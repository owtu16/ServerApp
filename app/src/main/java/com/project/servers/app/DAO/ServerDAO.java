package com.project.servers.app.DAO;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.servers.app.entity.Server;

public interface ServerDAO {
	// saves a server
	public void save(Server server);
	
	// updates a server
	public void update(Server server);
	
	// deletes a server
	public void delete(String ipAddress); // delete by passing ip address
	
	// finds all servers, regardless of location
	public List<Server> findAll();
	
	// finds cluster, will list location and number of servers at that location
	public HashMap<String,Long> findCluster();
	
	// returns all servers found at a particular location
	public List<Server> findAllByLocation(String location);
	
	// finds a server by looking for its IP Address
	public Server findById(Integer id) throws Exception;
	// finds a server by its IP address
	public Boolean findByIp(String ipAddress) throws Exception;

	public Boolean findLocation(String location) throws Exception;

	
	
}
