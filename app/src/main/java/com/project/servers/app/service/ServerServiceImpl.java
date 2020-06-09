package com.project.servers.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.servers.app.DAO.ServerDAO;
import com.project.servers.app.entity.Server;

@Service
public class ServerServiceImpl implements ServerService {

	private ServerDAO serverDAO;
	
	@Autowired
	public ServerServiceImpl(ServerDAO serverDAO) {
		this.serverDAO = serverDAO;
	}
	
	@Override
	public List<Server> findAllByLocation(Server server) {
		// TODO Auto-generated method stub
		
		return serverDAO.findAllByLocation(server);
	}

	@Override
	public List<Server> findAll() {
		// TODO Auto-generated method stub
		return serverDAO.findAll();
	}

	@Override
	public Integer count(Server server) {
		// TODO Auto-generated method stub
		return serverDAO.count(server);
	}

	@Override
	public void save(Server server) {
		// TODO Auto-generated method stub
		serverDAO.save(server);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		serverDAO.deleteById(id);
	}

}
