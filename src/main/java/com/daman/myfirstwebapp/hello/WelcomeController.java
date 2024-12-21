package com.daman.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	@GetMapping
	public String sayHelloJSP(ModelMap map) {
		if(map.containsAttribute("name")) {
			return "welcome";
		}
		return "redirect:/login";
	}

}
