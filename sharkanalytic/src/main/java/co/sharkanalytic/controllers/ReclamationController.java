package co.sharkanalytic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReclamationController {
	
	@RequestMapping(value = "/reclamation",method=RequestMethod.GET)
	public String home() {
		return "formreclammation";
	}
	
	@RequestMapping(value = "/postReclamation",method=RequestMethod.POST)
	public String postReclamation() {
		System.out.println("test");
		return "formreclammation";
	}

}
