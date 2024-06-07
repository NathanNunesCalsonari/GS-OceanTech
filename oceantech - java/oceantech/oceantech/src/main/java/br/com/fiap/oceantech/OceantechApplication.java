package br.com.fiap.oceantech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.fiap.oceantech")
@EnableJpaRepositories(basePackages = "br.com.fiap.oceantech.repository")
public class OceantechApplication {

	public static void main(String[] args) {
		SpringApplication.run(OceantechApplication.class, args);
	}

}
