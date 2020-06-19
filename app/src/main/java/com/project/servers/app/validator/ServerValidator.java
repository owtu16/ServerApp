package com.project.servers.app.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		// Regex for digit from 0 to 255. 
        String zeroTo255 
            = "(\\d{1,2}|(0|1)\\"
              + "d{2}|2[0-4]\\d|25[0-5])"; 
  
        // Regex for a digit from 0 to 255 and 
        // followed by a dot, repeat 4 times. 
        // this is the regex to validate an IP address. 
        String regex 
            = zeroTo255 + "\\."
              + zeroTo255 + "\\."
              + zeroTo255 + "\\."
              + zeroTo255; 
  
        // Compile the ReGex 
        Pattern p = Pattern.compile(regex); 
  
        // If the IP address is empty 
        // return false 
        if (ipAddress == null) { 
            return false; 
        } 
  
        // Pattern class contains matcher() method 
        // to find matching between given IP address 
        // and regular expression. 
        Matcher m = p.matcher(ipAddress); 
  
        // Return if the IP address 
        // matched the ReGex 
        return m.matches(); 
	}
	
	public static Boolean validateOsDetails(String osDetails) {
		if(!(osDetails.matches("Windows") || osDetails.matches("Linux"))) {
			return false;
		}
		return true;
	}
	
	public static Boolean validateLocation(String location) {
		return location.matches("^[A-Z][A-Za-z]{2,}(?: [A-Z][A-Za-z]*){0,2}$");
	}

}
