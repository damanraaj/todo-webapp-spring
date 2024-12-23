package com.daman.myfirstwebapp.hello;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	@GetMapping("/")
	public String sayHelloJSP(ModelMap map) {
		map.addAttribute("name", getLoggedInUser());
		return "welcome";
	}

	private String getLoggedInUser() {
		SecurityContext context = SecurityContextHolder.getContext();
		return context.getAuthentication().getName();
	}
}
