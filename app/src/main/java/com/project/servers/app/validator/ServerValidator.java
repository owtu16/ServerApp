package com.project.servers.app.validator;

import com.project.servers.app.entity.Server;

public class ServerValidator {
	
	public static void validateServer(Server server) throws Exception{
		
	}
	
	public static Boolean validateIpAddress(String IpAddress) {
		return null;
	}
	
	public static Boolean validateOsDetails(String OsDetails) {
		return null;
	}
	
	public static Boolean validateLocation(String location) {
		return location.matches("^[A-Z][A-Za-z]{2,}(?: [A-Z][A-Za-z]*){0,2}$");
	}

}
