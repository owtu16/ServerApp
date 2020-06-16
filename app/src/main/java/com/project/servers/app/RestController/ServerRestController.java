package com.project.servers.app.RestController;

import java.util.HashMap;
import java.util.List;

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

import com.project.servers.app.entity.Server;
import com.project.servers.app.service.ServerService;

//@CrossOrigin
@RestController
@RequestMapping("/servers")
public class ServerRestController{

	private ServerService serverService;
	
	public ServerRestController(ServerService serverService) {
		this.serverService = serverService;
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Server server = new Server();
		
		model.addAttribute("server",server);
		
		return "/servers/server-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("serverId") int id, Model model) {
		
		Server server = serverService.findById(id);
		
		model.addAttribute("server",server);
		
		return "/servers/server-form";
		
	}
	@PutMapping("/update")
	public String updateServer(@ModelAttribute("server") Server server) {
		serverService.update(server);
		
		return "redirect:/servers/list";
	}
	
	@PostMapping("/save") 
	public String saveServer(@ModelAttribute("server") Server server) {
		
		serverService.save(server);
		
		return "redirect:/servers/list";
		
	}
	// deletes server by passing the IP Address
	@DeleteMapping("/delete/{ipAddress}")
	public String delete(@PathVariable(value="ipAddress") String ip_address) {
		
	
		serverService.delete(ip_address);
		
		
		return "Server with id " + ip_address + " has been deleted";
//		
	}
	// returns cluster of servers with location and # of servers at that particular location
	@GetMapping("/cluster")
	public List<Server> listByLocation(Model model) {
		
		List<Server> servers = serverService.findByLocation();
		
		model.addAttribute("servers",servers);
		
		return servers;
		
	}
	// finds all servers regardless of location
	@GetMapping("/findAll")
	public List<Server> findAll(){
		List<Server> servers = serverService.findAll();
		return servers;
	}
	// find servers depending on their location
	@GetMapping("/showServersByLocation/{location}")
	public List<Server> serversList(@PathVariable(value="location") String location, Model model) {
		
		// returns a list of server objects based on location
		List<Server> servers = serverService.findAllByLocation(location);
		model.addAttribute("servers",servers);
//		return "/servers/servers-group";
		return servers;
	}
	
}

















