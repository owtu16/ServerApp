package com.project.servers.app.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.servers.app.DAO.ServerRepository;
import com.project.servers.app.entity.Server;

@Service
public class ServerServImpl implements ServerServ{

	@Autowired
	ServerRepository serverRepository;

	@Override
	public void save(Server server) throws Exception {
		
		serverRepository.save(server);
	}

	@Override
	public void update(Server server) throws Exception {
		
		serverRepository.save(server);
	}

	@Override
	public void delete(String ipAddress) throws Exception {
		// TODO Auto-generated method stub
		serverRepository.deleteById(ipAddress);
	}

	@Override
	public List<Server> findAll() throws Exception {
		// TODO Auto-generated method stub
		return serverRepository.findAll();
	}

	@Override
	public HashMap<Server, Long> findByClusters() throws Exception {
		// TODO Auto-generated method stub
		return serverRepository.findCluster();
	}

	@Override
	public Server findByIpAddress(String ipAddress) throws Exception {
		// TODO Auto-generated method stub
		return serverRepository.findById(ipAddress);
	}

	@Override
	public List<Server> findAllByLocation(String ipAddress) throws Exception {
		// TODO Auto-generated method stub
		return serverRepository.findAllById(ipAddress);
	}
	
	
}
