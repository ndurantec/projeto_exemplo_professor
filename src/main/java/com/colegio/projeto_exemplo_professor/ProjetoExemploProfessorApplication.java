package com.colegio.projeto_exemplo_professor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProjetoExemploProfessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoExemploProfessorApplication.class, args);
		System.out.println("Teste de execução");
	}

}
