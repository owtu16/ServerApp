package com.project.servers.app.DAO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.servers.app.entity.Server;

@Repository("servDAO")
public class ServDAOImpl implements ServerDAO {

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
		Server dbServer = entityManager.find(Server.class, server.getId());
		dbServer.setIpAddress(server.getIpAddress());
		dbServer.setOsDetails(server.getOsDetails());
		dbServer.setLocation(server.getLocation());
//		Server dbserver = entityManager.find(Server.class, server.getIpAddress());
		Server tempServer = entityManager.merge(dbServer);
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

//		String sql = "SELECT s.location, COUNT(*) AS total FROM Server s GROUP BY s.location ORDER BY s.location DESC";
//		
//		Query q = entityManager.createQuery(sql);
//		
//		HashMap<String, Long> clusters = (HashMap<String, Long>) q.getResultList();
		List<String> locationList = null;
		List<Long> numberOfServersAtLocation = null;

		String sqlLocation = "SELECT s.location FROM Server s GROUP BY s.location ORDER BY s.location DESC";
		Query qLocation = entityManager.createQuery(sqlLocation);

		String sqlNumberOfServers = "SELECT COUNT(*) AS total FROM Server s GROUP BY s.location ORDER BY s.location DESC";
		Query qNumberOfServers = entityManager.createQuery(sqlNumberOfServers);

		locationList = qLocation.getResultList();
		numberOfServersAtLocation = qNumberOfServers.getResultList();

		Iterator<String> i1 = locationList.iterator();
		Iterator<Long> i2 = numberOfServersAtLocation.iterator();

		HashMap<String, Long> cluster = new HashMap<>();

		while (i1.hasNext() && i2.hasNext()) {
			cluster.put(i1.next(), i2.next());
		}

		return cluster;

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
	public Server findById(Integer id) {
		// returns a server by looking for its IP address
		Server server = entityManager.find(Server.class, id);
		
		return server;
	}

	@Override
	public Boolean findByIp(String ipAddress) {
		// TODO Auto-generated method stub
		Boolean isPresent = false;
		String ip = ipAddress;
		List<String> result;
		String sql = "select s.ipAddress from Server s where s.ipAddress =: ip";
		
		Query q = entityManager.createQuery(sql);
		q.setParameter("ip", ip);
		
		result = q.getResultList();
//		System.out.println("the result " + result);
		
		if(!(result.isEmpty())) {
			isPresent = true;
		}
		
		return isPresent;
	}

	@Override
	public Boolean findLocation(String location) {
		Boolean locationExists = false;
		String sql = "from Server s where s.location ='"+location+"'";
		List<String> result;
		Query q = entityManager.createQuery(sql);
		result = q.getResultList();
		
		if(!(result.isEmpty())) {
			locationExists = true;
		}
		return locationExists;
	}

}
