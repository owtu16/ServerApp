package com.project.servers.app.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.servers.app.DAO.ServerDAO;
import com.project.servers.app.entity.Server;

@Service
@Transactional
public class ServerServiceImpl implements ServerService {

	private ServerDAO serverDAO;
	
	@Autowired
	public ServerServiceImpl(ServerDAO serverDAO) {
		this.serverDAO = serverDAO;
	}
	
	@Override
//	@Transactional
	public List<Server> findAllByLocation(String location) {
		// TODO Auto-generated method stub
		
		return serverDAO.findAllByLocation(location);
	}

	@Override
//	@Transactional
	public List<Server> findAll() {
		// TODO Auto-generated method stub
		return serverDAO.findAll();
	}

//	@Override
//	@Transactional
//	public Integer count(Server server) {
//		// TODO Auto-generated method stub
//		return serverDAO.count(server);
//	}

	@Override
//	@Transactional
	public void save(Server server) {
		// TODO Auto-generated method stub
		serverDAO.save(server);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		serverDAO.deleteById(id);
	}

	@Override
//	@Transactional
	public Server findById(int id) {
		// TODO Auto-generated method stub
		return serverDAO.findById(id);
	}

	@Override
//	@Transactional
	public HashMap<String, Long> count(int id) {
		// TODO Auto-generated method stub
		return serverDAO.count(id);
	}

	@Override
	public List<Server> findByLocation() {
		// TODO Auto-generated method stub
		return serverDAO.findByLocation();
	}

}
