package br.com.hackathon.easymed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class EasymedApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasymedApplication.class, args);
	}
}
