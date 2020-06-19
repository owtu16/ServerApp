package com.project.servers.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.servers.app.entity.Server;

public interface ServerService {

	// saves a server
		public void save(Server server) throws Exception;
		
		// updates a server
		public void update(Server server) throws Exception;
		
		// deletes a server
		public void delete(String ipAddress) throws Exception; // delete by passing ip address
		
		// finds all servers, regardless of location
		public List<Server> findAll() throws Exception;
		
		// finds cluster, will list location and number of servers at that location
		public HashMap<String,Long> findCluster() throws Exception;
		
		// returns all servers found at a particular location
		public List<Server> findAllByLocation(String location) throws Exception;
		
		// finds a server by looking for its IP Address
		public Server findById(Integer id) throws Exception;
		// returns server based on the IP address
		public Boolean findByIp(String ipAddress) throws Exception;

		public Boolean findLocation(String location) throws Exception;
	
}
