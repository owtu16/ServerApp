package com.project.servers.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.servers.DAO.ServerDAO;
import com.project.servers.model.Server;

@Service(value="ServerService")
public class ServerServiceImpl implements ServerService {
	
	@Autowired
	ServerDAO serverDAO;
	
	@Override
	public List<Server> getServerDetails() throws Exception {
		
		List<Server> serverList = null;
		try {
			serverList = serverDAO.getAllServerDetails();
		}catch(Exception e) {
			throw e;
		}
		return serverList;
	}

}
