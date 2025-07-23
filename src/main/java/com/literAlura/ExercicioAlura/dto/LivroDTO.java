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
    @JsonAlias("languages")
    public List<String> idioma;
    @JsonAlias("download_count")
    public Integer downloads;

    public LivroDTO(Integer id, String titulo, List<AutorLivros> autor, List<String> idioma, Integer downloads) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.downloads = downloads;
    }

    public List<String> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
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
                "\nTitulo: "+ titulo +
                "\nAutor: " + autor +
                "\nIdioma: " + idioma +
                "\nNúmero de downloads: " + downloads;
    }
}
