package com.project.servers.app.DAO.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.project.servers.app.DAO.ServerDAO;
import com.project.servers.app.entity.Server;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class ServerDAOTest {

	@Autowired
	private ServerDAO serverDAO;
	
	@Test
	public void checkServerRegistrationValidity() {
		Server server = new Server();
		server.setIpAddress("192.abc.def.1");
		server.setOsDetails("Windows");
		server.setLocation("San Jose");
		
		serverDAO.save(server);
		Assert.assertTrue(true);
	}
	
	@Test
	public void updateServerValidDetails() {
		Server server = new Server();
		server.setId(2);
		server.setIpAddress("192.168.1.1");
		server.setOsDetails("Windows");
		server.setLocation("Palo Alto");
		
		serverDAO.update(server);
		Assert.assertTrue(true);
	}
	
	@Test
	public void deleteServerValidDetails() {
		Server server = new Server();
		server.setIpAddress("192.168.1.1");
		serverDAO.delete(server.getIpAddress());
	}
	
	@Test
	public void checkIpAddressValidity() throws Exception {
		Server server = new Server();
		server.setIpAddress("192.168.abc.1");
		serverDAO.findByIp(server.getIpAddress());
		Assert.assertFalse(false);
	}
	
	@Test
	public void findByIpValid() {
		serverDAO.findByIp("192.168.1.1");
	}
	
	@Test
	public void findByIpInvalid() {
		serverDAO.findByIp("abc.def.ghi.jkl");
	}
	
	@Test
	public void findByIdValid() {
		serverDAO.findById(1);
	}
	
	@Test
	public void findbyIdInvalid() {
		serverDAO.findById(-1);
	}
	
	@Test
	public void findLocationValid() {
		serverDAO.findLocation("Texas");
	}
	
	@Test
	public void findLocationInvalid() {
		serverDAO.findLocation("123455");
	}
	
	@Test
	public void findLocationInvalid2() {
		serverDAO.findLocation("texas");
	}
	
	
	
}
