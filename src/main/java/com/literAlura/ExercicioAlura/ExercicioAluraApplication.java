package com.literAlura.ExercicioAlura;

import com.literAlura.ExercicioAlura.principal.Principal;
import com.literAlura.ExercicioAlura.repository.AutorRepositorio;
import com.literAlura.ExercicioAlura.repository.LivroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExercicioAluraApplication implements CommandLineRunner {

	@Autowired
	private LivroRepositorio livroRepositorio;

	@Autowired
	private AutorRepositorio autorepositorio;

	public static void main(String[] args) {
		SpringApplication.run(ExercicioAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal(livroRepositorio, autorepositorio);
		principal.exibeMenu();

	}
}
