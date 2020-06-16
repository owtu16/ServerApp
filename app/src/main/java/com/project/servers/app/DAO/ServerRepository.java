package com.project.servers.app.DAO;

import java.util.HashMap;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.servers.app.entity.Server;

public interface ServerRepository extends JpaRepository<Server, String> {

	HashMap<Server, Long> findCluster();

}
