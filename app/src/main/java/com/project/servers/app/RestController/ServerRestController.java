package com.project.servers.app.RestController;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

@Controller
@RequestMapping("/servers")
public class ServerRestController{

	private ServerService serverService;
	
	public ServerRestController(ServerService serverService) {
		this.serverService = serverService;
	}
	
//	@GetMapping("/list")
//	public String serverList(Model model) {
//		List<Server> servers = serverService.findAll();
//		
//		model.addAttribute("servers",servers);
//		
//		return "/servers/list-servers";
//	}
	
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
	
	@PostMapping("/save")
	public String saveServer(@ModelAttribute("server") Server server) {
		
		serverService.save(server);
		
		return "redirect:/servers/list";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("serverId") int id) {
		
		serverService.deleteById(id);
		
		return "redirect:/servers/list";
//		return "redirect:/servers/servers-group";
	}
	
	@GetMapping("/list")
	public String listByLocation(Model model) {
		
		List<Server> servers = serverService.findByLocation();
		
		model.addAttribute("servers",servers);
		
		return "/servers/server-cluster";
		
	}
	
	@GetMapping("/showServersByLocation")
	public String serversList(@RequestParam("serverLocation") String location, Model model) {
		
//		model.addAttribute("location",location);
		// returns a list of server objects based on location
		List<Server> servers = serverService.findAllByLocation(location);
		model.addAttribute("servers",servers);
		return "/servers/servers-group";
	}
	
}

















