package com.project.servers.app.validator.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.project.servers.app.entity.Server;
import com.project.servers.app.validator.ServerValidator;

public class ServerValidatorTest {
	
	@Rule
	public ExpectedException ee = ExpectedException.none();
	
	@Test
	public void validateValidServerDetails() throws Exception{
		Server server = new Server();
		server.setIpAddress("192.168.1.1");
		server.setOsDetails("Linux");
		server.setLocation("Texas");
		
		ServerValidator.validateServer(server);
	}
	
	@Test
	public void validateInvalidIpAddress() throws Exception{
		ee.expect(Exception.class);
		ee.expectMessage("ServerValidator.INVALID_SERVER_IP_ADDRESS");
		
		Server server = new Server();
		server.setIpAddress("192.168.1.1.169");
		server.setOsDetails("Linux");
		server.setLocation("Texas");
		
		ServerValidator.validateServer(server);
	}

	@Test
	public void validateInvalidIpAddress2() throws Exception{
		ee.expect(Exception.class);
		ee.expectMessage("ServerValidator.INVALID_SERVER_IP_ADDRESS");
		
		Server server = new Server();
		server.setIpAddress("abc.def.ghi.jkl");
		server.setOsDetails("Linux");
		server.setLocation("Texas");
		
		ServerValidator.validateServer(server);
	}
	
	@Test
	public void validateInvalidIpAddress3() throws Exception{
		ee.expect(Exception.class);
		ee.expectMessage("ServerValidator.INVALID_SERVER_IP_ADDRESS");
		
		Server server = new Server();
		server.setIpAddress("192.168.1");
		server.setOsDetails("Linux");
		server.setLocation("Texas");
		
		ServerValidator.validateServer(server);
	}
	
	@Test
	public void validateInvalidIpAddress4() throws Exception{
		ee.expect(Exception.class);
		ee.expectMessage("ServerValidator.INVALID_SERVER_IP_ADDRESS");
		
		Server server = new Server();
		server.setIpAddress("192.168.1.abc");
		server.setOsDetails("Linux");
		server.setLocation("Texas");
		
		ServerValidator.validateServer(server);
	}
	
	@Test
	public void validateInvalidIpAddress5() throws Exception{
		ee.expect(Exception.class);
		ee.expectMessage("ServerValidator.INVALID_SERVER_IP_ADDRESS");
		
		Server server = new Server();
		server.setIpAddress("999.999.999.257");
		server.setOsDetails("Linux");
		server.setLocation("Texas");
		
		ServerValidator.validateServer(server);
	}
	
	@Test
	public void validateInvalidOsDetails() throws Exception{
		ee.expect(Exception.class);
		ee.expectMessage("ServerValidator.INVALID_OPERATING_SYSTEM");
		
		Server server = new Server();
		server.setIpAddress("192.168.1.1");
		server.setOsDetails("Other");
		server.setLocation("Miami");
		
		ServerValidator.validateServer(server);
	}
	
	@Test
	public void validateLocation() throws Exception{
		ee.expect(Exception.class);
		ee.expectMessage("ServerValidator.INVALID_LOCATION");
		
		Server server = new Server();
		server.setIpAddress("192.168.1.1");
		server.setOsDetails("Windows");
		server.setLocation("4@#@!!@");
		
		ServerValidator.validateServer(server);
	}
	
	@Test
	public void validateLocation2() throws Exception{
		ee.expect(Exception.class);
		ee.expectMessage("ServerValidator.INVALID_LOCATION");
		
		Server server = new Server();
		server.setIpAddress("192.168.1.1");
		server.setOsDetails("Windows");
		server.setLocation("k");
		
		ServerValidator.validateServer(server);
	}
	
	@Test
	public void validateLocation3() throws Exception{
		ee.expect(Exception.class);
		ee.expectMessage("ServerValidator.INVALID_LOCATION");
		
		Server server = new Server();
		server.setIpAddress("192.168.1.1");
		server.setOsDetails("Windows");
		server.setLocation("europe");
		
		ServerValidator.validateServer(server);
	}
	
	
	
	
	
}
