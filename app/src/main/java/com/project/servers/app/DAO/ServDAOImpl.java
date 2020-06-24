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

	}

	@Override
	public void update(Server server) {
		// save or update the server
		Server dbServer = entityManager.find(Server.class, server.getId());
		dbServer.setIpAddress(server.getIpAddress());
		dbServer.setOsDetails(server.getOsDetails());
		dbServer.setLocation(server.getLocation());

		Server tempServer = entityManager.merge(dbServer);
		// update with ip address from server



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


		List<String> locationList = null;
		List<Long> numberOfServersAtLocation = null;

		String sqlLocation = "SELECT s.location FROM Server s GROUP BY s.location ORDER BY s.location DESC";
		String sqlNumberOfServers = "SELECT COUNT(*) AS total FROM Server s GROUP BY s.location ORDER BY s.location DESC";
		
		Query qLocation = entityManager.createQuery(sqlLocation);
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
	public HashMap<String, String> findAllByLocation(String location) {
		// use hashmap here
		// implement how you want 
		// find all servers found at a particular location
//		String var_location = location;
//		String sql = "from Server s where s.location =: serverLocation";
//		Query q = entityManager.createQuery(sql);
//		q.setParameter("serverLocation", var_location);
//		List<Server> serverByLocation = q.getResultList();
//		return serverByLocation;
		List<String> l1 = null;
		List<String> l2 = null;
		
		String sql = "SELECT s.ipAddress FROM Server s WHERE s.location = '"+location+"' GROUP BY s.ipAddress ORDER BY s.ipAddress DESC";
		String sql2 = "SELECT s.osDetails FROM Server s WHERE s.location = '"+location+"' GROUP BY s.ipAddress ORDER BY s.ipAddress DESC";
		
		Query qIp = entityManager.createQuery(sql);
		Query qOs = entityManager.createQuery(sql2);
		
		l1 = qIp.getResultList();
		l2 = qOs.getResultList();
		
		Iterator<String> i1 = l1.iterator();
		Iterator<String> i2 = l2.iterator();
		
		HashMap<String, String> result = new HashMap<>();
		
		while(i1.hasNext() && i2.hasNext()) {
			result.put(i1.next(), i2.next());
		}
		return result;
	}

	@Override
	public Server findById(Integer id){
		// returns a server by looking for its IP address
		Server server = entityManager.find(Server.class, id);
		
		return server;
	}
	
	

	@Override
	public Boolean findByIp(String ipAddress){
		
		Boolean isPresent = false;
		String ip = ipAddress;
		List<String> result;
		String sql = "select s.ipAddress from Server s where s.ipAddress =: ip";
		
		Query q = entityManager.createQuery(sql);
		q.setParameter("ip", ip);
		
		result = q.getResultList();

		
		if(!(result.isEmpty())) {
			isPresent = true;
		}
		
		return isPresent;
	}

	@Override
	public Boolean findLocation(String location){
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
