package co.sharkanalytic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@RequestMapping(value = "/",method=RequestMethod.GET)
	public String home() {
		return "login";
	}
	
	@RequestMapping(value = "/",method=RequestMethod.POST)
	public String postLogin() {
		
		return "index";
	}
	@RequestMapping(value = "/users",method=RequestMethod.GET)
	public String viewuser() {
		return "users";
	}

}

