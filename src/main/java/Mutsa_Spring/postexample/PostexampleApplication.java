package Mutsa_Spring.postexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PostexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostexampleApplication.class, args);
	}

}
