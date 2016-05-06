package co.sharkanalytic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SharkApplication {
	public static void main(String[] args) {
		SpringApplication.run(SharkApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String home() {
		return "Server is running on port 32000...";
	}
}
