package com.literAlura.ExercicioAlura.repository;

import com.literAlura.ExercicioAlura.entities.Livros;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepositorio extends JpaRepository<Livros, Integer> {


    @Query("SELECT l FROM Livros l JOIN l.idioma i WHERE i = :idioma")
    List<Livros> buscarPorIdioma(@Param("idioma") String idioma);

}
