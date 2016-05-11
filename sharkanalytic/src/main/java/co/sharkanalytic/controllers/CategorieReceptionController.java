package co.sharkanalytic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategorieReceptionController {
	@RequestMapping(value = "/typereclamation",method=RequestMethod.GET)
	public String home() {
		return "typereclamation";
	}
}
