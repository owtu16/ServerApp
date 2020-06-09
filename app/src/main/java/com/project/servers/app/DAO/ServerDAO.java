package com.project.servers.app.DAO;


import java.util.List;
import java.util.Map;

import com.project.servers.app.entity.Server;

public interface ServerDAO {

	public List<Server> findAllByLocation();
	
	public List<Server> findAll();
	
	public Map<?, ?> findKeyValuePairs();
	
	public Integer count();
	
}
