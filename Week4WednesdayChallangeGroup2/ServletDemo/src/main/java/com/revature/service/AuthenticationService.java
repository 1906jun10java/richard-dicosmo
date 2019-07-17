package com.revature.service;

import com.revature.beans.Credentials;
import com.revature.beans.User;

public class AuthenticationService {

	public AuthenticationService() {
	}

	//If the user is valid it will return a user, if not it will return null
	public User authenticateUser(Credentials creds) {
		User u = null;
		if(creds.getUsername().equals("merlin") && creds.getPassword().equals("cat")) {
			u = new User (6, "Merlin", "Higgins", creds.getUsername(), "merlin@wizcat.com");
		}
		return u;
	}
}
