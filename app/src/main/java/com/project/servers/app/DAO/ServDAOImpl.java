package com.project.servers.app.DAO;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.servers.app.entity.Server;
@Repository("servDAO")
public class ServDAOImpl implements ServerDAO{

	@Autowired
	EntityManager entityManager;

	@Override
	public void save(Server server) {
		// save or update the server
		Server dbserver = entityManager.merge(server);
		
		
		// update with ip address from server

//		server.setIpAddress(dbserver.getIpAddress());

	}

	@Override
	public void update(Server server) {
		// save or update the server
		
//		Server dbserver = entityManager.find(Server.class, server.getIpAddress());
		Server dbserver = entityManager.merge(server);
		// update with ip address from server

//		server.setIpAddress(dbserver.getIpAddress());

	}

	@Override
	public void delete(String ipAddress) {
		// Passes ip address to delete
		Query q = entityManager.createQuery("delete from Server where ipAddress =: ip_address");

		q.setParameter("ip_address", ipAddress);

		q.executeUpdate();

	}

	@Override
	public List<Server> findAll() {
		// Create a query

		String sql = "From Server";
		Query q = entityManager.createQuery(sql);
		// Get result list
		List<Server> servers = q.getResultList();

		// return the list
		return servers;
	}

	@Override
	public HashMap<String, Long> findCluster() {
		
		String sql = "SELECT s.location, COUNT(*) AS total FROM Server s GROUP BY s.location ORDER BY s.location DESC";
		
		Query q = entityManager.createQuery(sql);
		
		HashMap<String, Long> clusters = (HashMap<String, Long>) q.getResultList();
//		List<String> locationList = null;
//		List<Long> numberOfServersAtLocation = null;
//		
//		String sqlLocation = "SELECT s.location FROM Server s GROUP BY s.location ORDER BY s.location DESC";
//		Query qLocation = entityManager.createQuery(sqlLocation);
//		
//		String sqlNumberOfServers = "SELECT COUNT(*) AS total FROM Server s GROUP BY s.location ORDER BY s.location DESC";
//		Query qNumberOfServers = entityManager.createQuery(sqlNumberOfServers);
//		
//		locationList = qLocation.getResultList();
//		numberOfServersAtLocation = qNumberOfServers.getResultList();
//		
//		HashMap<Server,Long> cluster = new HashMap<>();
//		
//		if(cluster.isEmpty()) {
//			for (Long long1 : numberOfServersAtLocation) {
//				
//			}
//		}
		return clusters;
	}

	@Override
	public List<Server> findAllByLocation(String location) {
		// find all servers found at a particular location
		String var_location = location;
		String sql = "from Server s where s.location =: serverLocation";
		Query q = entityManager.createQuery(sql);
		q.setParameter("serverLocation", var_location);
		List<Server> serverByLocation = q.getResultList();
		return serverByLocation;
	}

	@Override
	public Server findByIp(String ipAddress) {
		// returns a server by looking for its IP address
		Server server = entityManager.find(Server.class, ipAddress);
		return server;
	}

}
