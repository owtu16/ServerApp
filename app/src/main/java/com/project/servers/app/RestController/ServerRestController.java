package com.project.servers.app.RestController;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.servers.app.entity.Server;
import com.project.servers.app.service.ServerService;

//@CrossOrigin
@RestController
@RequestMapping("/servers")
public class ServerRestController {

	@Autowired
	private ServerService serverService;
	@Autowired
	private Environment environment;
	
	static Logger logger = LogManager.getLogger(ServerRestController.class.getName());
	
	@PostMapping("/save")
//	public String saveServer(@ModelAttribute("server") Server server) throws Exception {
//	public String saveServer(@RequestBody Server server) throws Exception {
	public ResponseEntity<String> saveServer(@RequestBody Server server) throws Exception{
		
		try {
			logger.info("TRYING TO SAVE A NEW SERVER");
			serverService.save(server);
			String message = "ServerRestController.SERVER_ADDED";
//			return "redirect:/servers/findall";
			logger.info("SERVER REGISTRATION SUCCESSFUL WITH IP ADDRESS " + server.getIpAddress());
			return new ResponseEntity<String>(environment.getProperty(message),HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}

	}

	@PutMapping("/update")
//	public String updateServer(@ModelAttribute("server") Server server) throws Exception {
	public void updateServer(@RequestBody Server server) throws Exception {
		try {
			Integer id = server.getId();
			
			Server dbserver = serverService.findById(id);
			
		
			if(dbserver == null)
				throw new Exception("Server not found");
//			
//			String ip = dbserver.getIpAddress();
			dbserver.setIpAddress(server.getIpAddress());
			dbserver.setLocation(server.getLocation());
			dbserver.setOsDetails(server.getOsDetails());
			System.out.println(dbserver);
			serverService.update(dbserver);

//			return "redirect:/servers/findall";
		} catch (Exception e) {
			throw new Exception(environment.getProperty(e.getMessage()));
		}
	}

	// deletes server by passing the IP Address
	@DeleteMapping("/delete/{ipAddress}")
	public String delete(@PathVariable(value = "ipAddress") String ip_address) throws Exception {
		try {
			serverService.delete(ip_address);

			return "Server with id " + ip_address + " has been deleted";
		} catch (Exception e) {
			throw new Exception("Error");
		}

	}

	// finds all servers regardless of location
	@GetMapping("/findall")
	public List<Server> findAll() throws Exception {
		try {
			
//			logger.error(environment.getProperty("ServerRestController.FIND_ALL_SERVERS"));
			logger.info(environment.getProperty("ServerRestController.FIND_ALL_SERVERS"));
			
			List<Server> servers = serverService.findAll();
			return servers;
		} catch (Exception e) {
//			
			throw new Exception("Error");
		}
	}

	// returns cluster of servers with location and # of servers at that particular
	// location
	@GetMapping("/cluster")
	public HashMap<String, Long> findCluster(Model model) throws Exception {
		try {
			HashMap<String, Long> servers = serverService.findCluster();

			model.addAttribute("servers", servers);

			return servers;
		} catch (Exception e) {
			
			throw new Exception("Error");
		}

	}

	// find servers depending on their location
	@GetMapping("/showServersByLocation/{location}")
	public List<Server> serversList(@PathVariable(value = "location") String location, Model model) throws Exception {
		try {
			// returns a list of server objects based on location
			List<Server> servers = serverService.findAllByLocation(location);
			model.addAttribute("servers", servers);
//		return "/servers/servers-group";
			return servers;
		} catch (Exception e) {
			throw new Exception("Error");
		}
	}

}
