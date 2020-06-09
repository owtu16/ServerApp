package com.project.servers.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="server_tb")
public class Server {

	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ip_address")
	private String ipAddress;
	
	@Column(name="os_details")
	private String osDetails;
	
	@Column(name="location")
	private String location;
	
	// define constructors
	
	public Server() {
		
	}

	public Server(String ipAddress, String osDetails, String location) {
		this.ipAddress = ipAddress;
		this.osDetails = osDetails;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getOsDetails() {
		return osDetails;
	}

	public void setOsDetails(String osDetails) {
		this.osDetails = osDetails;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Server [ipAddress=" + ipAddress + ", osDetails=" + osDetails + ", location=" + location + "]";
	}
	
	
	
}
