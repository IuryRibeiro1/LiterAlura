package com.literAlura.ExercicioAlura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.literAlura.ExercicioAlura.entities.AutorLivros;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LivroDTO {

    public Integer id;
    @JsonAlias("title")
    public String titulo;
    @JsonAlias("authors")
    public List<AutorLivros> autor;


    public LivroDTO(Integer id, String titulo, List<AutorLivros> autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public LivroDTO(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<AutorLivros> getAutor() {
        return autor;
    }

    public void setAutor(List<AutorLivros> autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor;
    }
}
