package com.daman.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SayHelloController {

	@GetMapping
	public String sayHelloJSP() {
		return "sayHello";
	}

}
