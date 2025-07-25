package com.literAlura.ExercicioAlura.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.literAlura.ExercicioAlura.dto.AutorDTO;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Transient;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorLivros(@JsonAlias("name")String nome, @JsonAlias("birth_year") Integer nascimento, @JsonAlias("death_year") Integer falecimento) {
}
