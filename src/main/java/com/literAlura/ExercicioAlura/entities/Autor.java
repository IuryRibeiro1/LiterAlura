package com.literAlura.ExercicioAlura.entities;

import com.literAlura.ExercicioAlura.dto.AutorDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public String nome;
    public String nascimento;
    public String anoMorte;

    @OneToMany(mappedBy = "autor" , fetch = FetchType.EAGER)
    private List<Livros> livros = new ArrayList<>();

    public Autor(AutorLivros autorLivros) {
        this.nome = autorLivros.nome();
        this.nascimento = String.valueOf(autorLivros.nascimento());
        this.anoMorte = String.valueOf(autorLivros.falecimento());
    }

    public Autor(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Livros> getLivros() {
        return livros;
    }

    public void setLivros(List<Livros> livros) {
        livros.forEach(l -> l.setAutor(this));
        this.livros = livros;
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

    @Override
    public String toString() {
        return
                "autor=" + nome +
                ", nascimento='" + nascimento + '\'' +
                ", anoMorte='" + anoMorte;
    }
}
