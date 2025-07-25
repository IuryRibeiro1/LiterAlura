package com.literAlura.ExercicioAlura.entities;

import com.literAlura.ExercicioAlura.dto.LivroDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "livros")
public class Livros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(unique = true)
    public String titulo;

    public List<String> idioma;

    public Integer downloads;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Livros(LivroDTO livroDTO) {
        this.titulo = livroDTO.titulo;
        this.idioma = livroDTO.idioma;
        this.downloads = livroDTO.downloads;

        if (livroDTO.autor != null && !livroDTO.autor.isEmpty()) {
            var autorDTO = livroDTO.autor.get(0);
            this.autor = new Autor(autorDTO);
        }
    }

    public Livros(){

    }

    public Integer getId() {
        return id;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
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

    public String toString() {
        String nomeAutor = (autor != null) ? autor.nome : "Desconhecido";
        return "\n---------- LIVRO ----------" +
                "\nTítulo: " + titulo +
                "\nAutor: " + nomeAutor +
                "\nIdioma: " + String.join(", ", idioma) +
                "\nDownloads: " + downloads +
                "\n-------------------------";
    }
}

