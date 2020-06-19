package com.project.servers.app.RestController;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

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
import com.project.servers.app.validator.ServerValidator;

//@CrossOrigin
@RestController
@RequestMapping("servers")
public class ServerRestController {

	@Autowired
	private ServerService serverService;
	@Autowired
	private Environment environment;
	
	static Logger logger = LogManager.getLogger(ServerRestController.class);
	
	@PostMapping("save")
	public ResponseEntity<String> saveServer(@RequestBody Server server) throws Exception{
		
		try {

			logger.info("NEW SERVER REGISTRATION REQUESTED BY USER");
			Boolean serverExists = serverService.findByIp(server.getIpAddress());

			if(serverExists) {
				throw new Exception("SERVER ALREADY EXISTS");
			}
			serverService.save(server);
			String message = "ServerRestController.SERVER_ADDED";

			logger.info("SERVER REGISTRATION SUCCESSFUL WITH IP ADDRESS " + server.getIpAddress());

			return new ResponseEntity<String>(environment.getProperty(message),HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}

	}

	@PutMapping("update")
	public ResponseEntity<String> updateServer(@RequestBody Server server) throws Exception{
		try {
		
			Boolean serverExists = serverService.findByIp(server.getIpAddress());
			
			if(!serverExists)
				throw new Exception("Server not found");
			serverService.update(server);

			String successMsg = environment.getProperty("ServerRestController.SERVER_UPDATED");
			

			return new ResponseEntity<String>(successMsg, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, environment.getProperty(e.getMessage()));
		}
	}

	// deletes server by passing the IP Address
	@DeleteMapping("delete/{ipAddress}")
	public ResponseEntity<String> delete(@PathVariable(value="ipAddress") String ip_address) throws Exception {
		try {
			Boolean serverExists = serverService.findByIp(ip_address);
			
			if(!serverExists) {
				throw new Exception("Server is not present in the database!");
			}
			
			logger.warn("Request to delete server with IP Address " + ip_address + " has been initiated");
			serverService.delete(ip_address);
			logger.info("Server " + ip_address + " has been successfully deleted");
			return new ResponseEntity<String>(environment.getProperty("ServerRestController.SERVER_DELETED"),HttpStatus.OK);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}

	}

	// finds all servers regardless of location
	@GetMapping("findall")
	public ResponseEntity<List<Server>> findAll() throws Exception{
		List<Server> list = null;
		try {
			
			logger.info(environment.getProperty("ServerRestController.FIND_ALL_SERVERS"));
			
			
			list = serverService.findAll();
			
			
			ResponseEntity<List<Server>> response = new ResponseEntity<List<Server>>(list,HttpStatus.OK);
			return response;
		} catch (Exception e) {
//			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}

	// returns cluster of servers with location and # of servers at that particular
	// location
	@GetMapping("cluster")
	public ResponseEntity<HashMap<String,Long>> findCluster(Model model) throws Exception{
		HashMap<String,Long> map = null;
		try {

			map = serverService.findCluster();

			model.addAttribute("servers", map);
			
			ResponseEntity<HashMap<String,Long>> response = new ResponseEntity<HashMap<String,Long>>(map,HttpStatus.OK);
			return response;
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}

	}

	// find servers depending on their location
	@GetMapping("showServersByLocation/{location}")
	public ResponseEntity<List<Server>> serversList(@PathVariable(value = "location") String location, Model model) throws Exception {
		List<Server> list = null;
		try {
			// returns a list of server objects based on location
			Boolean locationExists = serverService.findLocation(location);
			if(!locationExists) {
				throw new Exception("Deosn't exists");
			}
			list = serverService.findAllByLocation(location);
			
			model.addAttribute("servers", list);
			
			ResponseEntity<List<Server>> response = new ResponseEntity<List<Server>>(list,HttpStatus.OK);
			
			return response;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}

}
