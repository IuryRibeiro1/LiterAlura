package com.literAlura.ExercicioAlura;

import com.literAlura.ExercicioAlura.principal.Principal;
import com.literAlura.ExercicioAlura.service.LivroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExercicioAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExercicioAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();
		principal.exibeMenu();

	}
}
