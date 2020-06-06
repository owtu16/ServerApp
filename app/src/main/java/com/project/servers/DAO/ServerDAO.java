package com.project.servers.DAO;

import com.project.servers.model.Server;

public interface ServerDAO {
	
	public String add(Server server) throws Exception;
	
	public String delete(Server server) throws Exception;
	
	public String update(Server server) throws Exception;

}
