package co.sharkanalytic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ModeReceptionController {
	@RequestMapping(value = "/modereception",method=RequestMethod.GET)
	public String home() {
		return "modereception";
	}
}
