package co.sharkanalytic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@SpringBootApplication
@Controller
@ComponentScan
@EnableJpaRepositories(basePackages = "co.sharkanalytic.repository")
public class SharkApplication {
	public static void main(String[] args) {
		SpringApplication.run(SharkApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String home() {
		return "login";
	}

	@SuppressWarnings("unchecked")
	@Bean
	public Jackson2ObjectMapperBuilder configureObjectMapper() {
		return new Jackson2ObjectMapperBuilder().modulesToInstall(Hibernate4Module.class);
	}
}
