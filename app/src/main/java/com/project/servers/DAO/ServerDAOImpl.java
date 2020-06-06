package com.project.servers.DAO;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.servers.model.Server;

@Repository(value="ServerDAO")
public class ServerDAOImpl implements ServerDAO {
	
//	@Autowired
//	EntityManager em;
	

	@Override
	public String add(Server server) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Server server) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Server server) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Server> getAllServerDetails() throws Exception {
		// TODO Auto-generated method stub
		List<Server> serverList = new ArrayList<>();
		
		Server s1 = new Server();
		s1.setIpAddress("192.168.8.8");
		s1.setLocation("Palo Alto");
		s1.setOsDetails("Windows");
		
		Server s2 = new Server();
		s2.setIpAddress("123.23.21.82");
		s2.setLocation("Palo Alto");
		s2.setOsDetails("Linux");
		
		Server s3 = new Server();
		s3.setIpAddress("23.21.328.28");
		s3.setLocation("Texas");
		s3.setOsDetails("Linux");
		
		Server s4 = new Server();
		s4.setIpAddress("23.83.183.0");
		s4.setLocation("New Jersey");
		s4.setOsDetails("Linux");
		
		Server s5 = new Server();
		s5.setIpAddress("48.91.1.1");
		s5.setLocation("Texas");
		s5.setOsDetails("Windows");
		
		Server s6 = new Server();
		s6.setIpAddress("1.1.8.8");
		s6.setLocation("New Jersey");
		s6.setOsDetails("Linux");
		
		Server s7 = new Server();
		s7.setIpAddress("8.8.21.28");
		s7.setLocation("Texas");
		s7.setOsDetails("Windows");
		
		Server s8 = new Server();
		s8.setIpAddress("123.23.21.82");
		s8.setLocation("Palo Alto");
		s8.setOsDetails("Linux");
		
		Server s9 = new Server();
		s9.setIpAddress("82.82.81.12");
		s9.setLocation("New Jersey");
		s9.setOsDetails("Windows");
		
		Server s10 = new Server();
		s10.setIpAddress("9.32.8.120");
		s10.setLocation("Texas");
		s10.setOsDetails("Linux");
		
		serverList.add(s1);
		serverList.add(s2);
		serverList.add(s3);
		serverList.add(s4);
		serverList.add(s5);
		serverList.add(s6);
		serverList.add(s7);
		serverList.add(s8);
		serverList.add(s9);
		serverList.add(s10);
		
		return serverList;
	}

}
