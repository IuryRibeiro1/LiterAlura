package com.literAlura.ExercicioAlura.repository;

import com.literAlura.ExercicioAlura.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepositorio extends JpaRepository<Autor, Integer> {

    List<Autor> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT a FROM Autor a WHERE a.nascimento <= :ano AND (a.anoMorte IS NULL OR a.anoMorte >= :ano)")
    List<Autor> findByAnoEscolhido(@Param("ano") Integer ano);

}
