package com.project.servers.app.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.servers.app.DAO.ServerDAO;
import com.project.servers.app.entity.Server;

@Service
@Transactional
public class ServerServiceImpl implements ServerService {
	
	@Autowired
	@Qualifier("servDAO")
	private ServerDAO serverDAO;

	@Override
	public void save(Server server) throws Exception {
		serverDAO.save(server);
		
	}

	@Override
	public void update(Server server) throws Exception {
		serverDAO.update(server);
		
	}

	@Override
	public void delete(String ipAddress) throws Exception {
		serverDAO.delete(ipAddress);
		
	}

	@Override
	public List<Server> findAll() throws Exception {
		
		return serverDAO.findAll();
	}

	@Override
	public HashMap<String, Long> findCluster() throws Exception {
		
		return serverDAO.findCluster();
	}

	@Override
	public List<Server> findAllByLocation(String location) throws Exception {
		
		return serverDAO.findAllByLocation(location);
	}

	@Override
	public Server findById(Integer id) throws Exception {
		
		return serverDAO.findById(id);
	}

	
}
