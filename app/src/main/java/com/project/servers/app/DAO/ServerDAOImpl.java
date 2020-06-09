package com.project.servers.app.DAO;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.project.servers.app.entity.Server;

@Repository
public class ServerDAOImpl implements ServerDAO {
	
	EntityManager entityManager;
	
	public ServerDAOImpl(EntityManager entityManager) {
		// 
		this.entityManager = entityManager;
	}

	@Override
	public List<Server> findAllByLocation() {
		// 
		return null;
	}

	@Override
	public Map<?, ?> findKeyValuePairs() {
		// 
		return null;
	}

	@Override
	public Integer count() {
		// 
		return null;
	}

	@Override
	public List<Server> findAll() {
		// Create a query
		Query q = entityManager.createQuery("from Server");
		// Get result list
		List<Server> servers = q.getResultList();
		// return the list
		return servers;
	}

}
