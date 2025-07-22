package com.literAlura.ExercicioAlura.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorLivros(@JsonAlias("name") String nome,@JsonAlias("birth_year") String aniversario,@JsonAlias("death_year") String aniversario_morte) {
}
