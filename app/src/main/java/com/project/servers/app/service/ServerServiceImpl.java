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
	@Autowired
	private ServerDAO serverDAO;

	@Override
	public void save(Server server) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Server server) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String ipAddress) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Server> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Long> findCluster() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Server> findAllByLocation(String location) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Server findByIp(String ipAddress) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
