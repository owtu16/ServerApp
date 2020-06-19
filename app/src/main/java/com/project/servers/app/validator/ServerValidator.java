package com.project.servers.app.validator;

import com.project.servers.app.entity.Server;

public class ServerValidator {
	
	public static void validateServer(Server server) throws Exception{
		if(!validateIpAddress(server.getIpAddress())) {
			throw new Exception("ServerValidator.INVALID_SERVER_IP_ADDRESS");
		}
		if(!validateOsDetails(server.getOsDetails())){
			throw new Exception("ServerValidator.INVALID_OPERATING_SYSTEM");
		}
		if(!validateLocation(server.getLocation())) {
			throw new Exception("ServerValidator.INVALID_LOCATION");
		}
	}
	
	public static Boolean validateIpAddress(String ipAddress) {
		return ipAddress.matches("");
	}
	
	public static Boolean validateOsDetails(String osDetails) {
		if(!(osDetails == "Windows" || osDetails == "Linux")) {
			return false;
		}
		return true;
	}
	
	public static Boolean validateLocation(String location) {
		return location.matches("^[A-Z][A-Za-z]{2,}(?: [A-Z][A-Za-z]*){0,2}$");
	}

}
