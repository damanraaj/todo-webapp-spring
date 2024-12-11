package com.daman.myfirstwebapp.login;

import org.springframework.stereotype.Component;

@Component
public class AuthService {
	
	public boolean authenticate(String name, String password) {
		return name.equals("admin");
	}

}
