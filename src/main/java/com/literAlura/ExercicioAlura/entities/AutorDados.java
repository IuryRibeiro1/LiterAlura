package com.literAlura.ExercicioAlura.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.literAlura.ExercicioAlura.dto.AutorDTO;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDados(@JsonAlias("results") List<AutorDTO> dados) {
}
