package com.daman.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("name")
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private AuthService authService;

	@GetMapping("login")
	public String login() {
		return "login";
	}

	@PostMapping("login")
	public String goToWelcome(@RequestParam String username, @RequestParam String password, ModelMap map) {
		map.put("name", username);
		logger.debug("User {} attempted to login", username);
		if (authService.authenticate(username, password)) {

			return "welcome";
		} else {

			return "login";
		}
	}

	@GetMapping("logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/login";
	}
}
