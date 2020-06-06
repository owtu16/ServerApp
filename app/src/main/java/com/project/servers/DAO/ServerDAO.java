package com.project.servers.DAO;

import java.util.List;

import com.project.servers.model.Server;

public interface ServerDAO {
	
	public List<Server> getAllServerDetails() throws Exception;
	
	public String add(Server server) throws Exception;
	
	public String delete(Server server) throws Exception;
	
	public String update(Server server) throws Exception;

}
