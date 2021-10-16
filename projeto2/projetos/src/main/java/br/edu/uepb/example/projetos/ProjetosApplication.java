package br.edu.uepb.example.projetos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProjetosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetosApplication.class, args);
	}
	
}