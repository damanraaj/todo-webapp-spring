package com.daman.myfirstwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("/")
    @ResponseBody
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping("sayhtml")
    @ResponseBody
    public String sayHtml() {
        return "<html><body><h1>Hello World in html</h1></body></html>";
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJSP() {
        return "sayHello";
    }

}
