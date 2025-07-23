package com.literAlura.ExercicioAlura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.literAlura.ExercicioAlura.entities.AutorLivros;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorDTO {

    @JsonAlias("authors")
    public List<AutorLivros> autor;

    @JsonAlias("birth_year")
    public String nascimento;

    @JsonAlias("death_year")
    public String anoMorte;


    public AutorDTO(List<AutorLivros> autor, String nascimento, String anoMorte) {
        this.autor = autor;
        this.nascimento = nascimento;
        this.anoMorte = anoMorte;
    }


    public AutorDTO(){

    }

    public List<AutorLivros> getAutor() {
        return autor;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getAnoMorte() {
        return anoMorte;
    }

    public void setAnoMorte(String anoMorte) {
        this.anoMorte = anoMorte;
    }

    public void setAutor(List<AutorLivros> autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return
                "autor=" + autor +
                "Nasceu: " + nascimento +
                "Faleceu: " + anoMorte;
    }
}
