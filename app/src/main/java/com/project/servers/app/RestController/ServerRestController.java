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
import com.project.servers.app.service.ServerService;

//@CrossOrigin
@RestController
@RequestMapping("/servers")
public class ServerRestController {

	@Autowired
	private ServerService serverService;

	@PostMapping("/save")
	public String saveServer(@ModelAttribute("server") Server server) throws Exception {

		serverService.save(server);

		return "redirect:/servers/list";

	}

	@PutMapping("/update")
	public String updateServer(@ModelAttribute("server") Server server) throws Exception {
		serverService.update(server);

		return "redirect:/servers/list";
	}

	// deletes server by passing the IP Address
	@DeleteMapping("/delete/{ipAddress}")
	public String delete(@PathVariable(value = "ipAddress") String ip_address) throws Exception {

		serverService.delete(ip_address);

		return "Server with id " + ip_address + " has been deleted";

	}

	// finds all servers regardless of location
	@GetMapping("/findAll")
	public List<Server> findAll() throws Exception {
		List<Server> servers = serverService.findAll();
		return servers;
	}



	// returns cluster of servers with location and # of servers at that particular
	// location
	@GetMapping("/cluster")
	public HashMap<String,Long> findCluster(Model model) throws Exception {

		HashMap<String,Long> servers = serverService.findCluster();

		model.addAttribute("servers", servers);

		return servers;

	}

	// find servers depending on their location
	@GetMapping("/showServersByLocation/{location}")
	public List<Server> serversList(@PathVariable(value = "location") String location, Model model) throws Exception {

		// returns a list of server objects based on location
		List<Server> servers = serverService.findAllByLocation(location);
		model.addAttribute("servers", servers);
//		return "/servers/servers-group";
		return servers;
	}

}
