package co.sharkanalytic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class SharkApplication {
	public static void main(String[] args) {
		SpringApplication.run(SharkApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String home() {
		return "login";
	}
	
}
