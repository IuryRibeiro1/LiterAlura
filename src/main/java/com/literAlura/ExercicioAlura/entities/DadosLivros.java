package com.literAlura.ExercicioAlura.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.literAlura.ExercicioAlura.dto.LivroDTO;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivros(@JsonAlias("results")List<LivroDTO> dados) {

}
