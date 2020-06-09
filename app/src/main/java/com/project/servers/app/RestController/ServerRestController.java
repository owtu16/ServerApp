package com.project.servers.app.RestController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.servers.app.entity.Server;
import com.project.servers.app.service.ServerService;

@RestController
@RequestMapping("/servers")
public class ServerRestController {

	private ServerService serverService;
	
	public ServerRestController(ServerService serverService) {
		this.serverService = serverService;
	}
	// needs to be @PathVariable int serverId and @GetMapping
	@GetMapping("/count/{serverId}")
	public HashMap<String, Long> count(@PathVariable int serverId){
		HashMap<String, Long> map = serverService.count(serverId);
		
		return map;
	}
//	@GetMapping("/count")
//	public Integer count(@RequestBody Server server) {
//		Integer count = serverService.count(server);
//		return count;
//	}
	
	// Returns all the servers from your database
	@GetMapping("/displayAll")
	public List<Server> findAll(){
		return serverService.findAll();
	}
	
	@GetMapping("/servers/{serverId}")
	public Server getServer(@PathVariable int serverId) {
		Server server = serverService.findById(serverId);
		
		if(server == null) {
			throw new RuntimeException("Server id not found - " + serverId);
		}
		
		return server;
	}
	
	// Add a new server to your database
	@PostMapping("/servers")
	public Server addServer(@RequestBody Server server) {
		
		server.setId(0);
		
		serverService.save(server);
		
		return server;
	}
	
	// Update a server from your database
	@PutMapping("/servers")
	public Server updateServer(@RequestBody Server server) {
		serverService.save(server);
		return server;
	}
	// Deletes a server from your database, you must provide the serverId
	@DeleteMapping("/servers/{serverId}")
	public String deleteServer(@PathVariable int serverId) {
		
		
		Server tempServer = serverService.findById(serverId);
		
		if(tempServer == null) {
			throw new RuntimeException("Server id not found - " + serverId);
		}
		
		serverService.deleteById(serverId);
		
		return "Deleted server id - " + serverId;
	}
}
