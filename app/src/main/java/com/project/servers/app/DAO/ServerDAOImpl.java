package com.project.servers.app.DAO;

import java.util.HashMap;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.project.servers.app.entity.Server;

@Repository
public class ServerDAOImpl implements ServerDAO {
	EntityManager entityManager;
	public ServerDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public List<Server> findAllByLocation(Server server) {
		String location = server.getLocation();
		String sql = "select s.ip_address from server_tb s where s.location =: serverLocation";
		Query q = entityManager.createQuery(sql);
		q.setParameter("serverLocation", location);
		List<Server> serverByLocation = q.getResultList();
		return serverByLocation;
	}
//	@Override
//	public Integer count(Server server) {
		// counts the number of servers at a particular location: only 3 locations are available
		// Palo Alto, Texas, and New Jersey
//		String sql = "select count(*) from server_tb s where s.location =: serverLocation";
		
//		Query q = entityManager.createQuery(sql);
//		q.setParameter("serverLocation", server.getLocation());
//		Integer result = (Integer) q.getSingleResult();
//		return result;
//	}
	@Override
	public List<Server> findAll() {
		// Create a query
		Query q = entityManager.createQuery("from Server");
		// Get result list
		List<Server> servers = q.getResultList();
		// return the list
		return servers;
	}
	@Override
	public void save(Server server) {
		// save or update the server
		Server dbserver = entityManager.merge(server);
		// update with id from db, so we can get generated id for save/insert
		server.setId(dbserver.getId());
	}
	@Override
	public void deleteById(int id) {
		// delete object with primary key
		Query q = entityManager.createQuery("delete from Server where id =: serverId");
		
		q.setParameter("serverId", id);
		
		q.executeUpdate();
	}
	@Override
	public Server findById(int id) {
		// TODO Auto-generated method stub
		Server server = entityManager.find(Server.class, id);
		
		return server;
	}
	@Override
	public HashMap<String, Long> count(int id) {
		// TODO Auto-generated method stub
		Server server = entityManager.find(Server.class, id);
		String serverLocation = server.getLocation();
		String sql = "SELECT COUNT(*) FROM Server s WHERE s.location =: serverLocation";
		Query q = entityManager.createQuery(sql);
		q.setParameter("serverLocation", serverLocation);
		Long result = (Long) q.getSingleResult();
		HashMap<String, Long> mapResult = new HashMap<>();
		mapResult.put(serverLocation, result);
		return mapResult;
	}
	

}
