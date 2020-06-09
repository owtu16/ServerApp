package com.project.servers.app.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.servers.app.entity.Server;
import com.project.servers.app.service.ServerService;

@RestController
@RequestMapping("/main")
public class ServerRestController {

	private ServerService serverService;
	
	public ServerRestController(ServerService serverService) {
		this.serverService = serverService;
	}
	
	@GetMapping("/servers")
	public List<Server> findAll(){
		return serverService.findAll();
	}
	
	@PostMapping("/servers")
	public Server addServer(@RequestBody Server server) {
		
		server.setId(0);
		
		serverService.save(server);
		
		return server;
	}
}
