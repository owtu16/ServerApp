package com.project.servers.app.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.servers.app.DAO.ServerRepository;
import com.project.servers.app.entity.Server;

@Service
public class ServerServImpl {

	@Autowired
	ServerRepository serverRepository;
	
	
}
