package com.project.servers.app.RestController;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.project.servers.app.service.ServerServ;


//@CrossOrigin
@RestController
@RequestMapping("/servers")
public class ServerRestController {

	@Autowired
	private ServerServ serverServ;

//	public ServerRestController(ServerService serverService) {
//		this.serverService = serverService;
//	}
	@PostMapping("/save")
	public String saveServer(@ModelAttribute("server") Server server) throws Exception {

		serverServ.save(server);

		return "redirect:/servers/list";

	}

	@PutMapping("/update")
	public String updateServer(@ModelAttribute("server") Server server) throws Exception {
		serverServ.update(server);

		return "redirect:/servers/list";
	}

	@DeleteMapping("/delete/{ipAddress}")
	public String delete(@PathVariable(value = "ipAddress") String ip_address) throws Exception {

		serverServ.delete(ip_address);

		return "Server with id " + ip_address + " has been deleted";
//		
	}

	// finds all servers regardless of location
	@GetMapping("/findAll")
	public List<Server> findAll() throws Exception {
		List<Server> servers = serverServ.findAll();
		return servers;
	}

	// returns cluster of servers with location and # of servers at that particular
	// location
	@GetMapping("/cluster")
	public HashMap<Server, Long> listByLocation(Model model) throws Exception {

		HashMap<Server, Long> servers = serverServ.findByClusters();

		model.addAttribute("servers", servers);

		return servers;

	}
	
	@GetMapping("/findByIp")
	public Server findByIp(@PathVariable(value="ipAddress") String ipAddress, Model model) throws Exception {
		
		Server server = serverServ.findByIpAddress(ipAddress);
		model.addAttribute("server",server);
		
		return server;
		
	}

	// find servers depending on their location
	@GetMapping("/showServersByLocation/{location}")
	public List<Server> serversList(@PathVariable(value = "location") String location, Model model) throws Exception {

		// returns a list of server objects based on location
		List<Server> servers = serverServ.findAllByLocation(location);
		model.addAttribute("servers", servers);
//			return "/servers/servers-group";
		return servers;
	}

//	@GetMapping("/showFormForAdd")
//	public String showFormForAdd(Model model) {
//
//		Server server = new Server();
//
//		model.addAttribute("server", server);
//
//		return "/servers/server-form";
//	}

//	@GetMapping("/showFormForUpdate")
//	public String showFormForUpdate(@RequestParam("serverId") int id, Model model) {
//		
//		Server server = serverServ.findById(id);
//		
//		model.addAttribute("server",server);
//		
//		return "/servers/server-form";
//		
//	}

	// deletes server by passing the IP Address

}
