package com.daman.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	@GetMapping("login")
	public String login() {
		return "login";
	}

	@PostMapping("login")
	public String goToWelcome(@RequestParam String username, @RequestParam String password, ModelMap map) {
		map.put("name",username);
		map.put("password",password);
		return "welcome";
	}
}
