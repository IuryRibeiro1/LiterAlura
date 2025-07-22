package com.literAlura.ExercicioAlura.principal;

import com.literAlura.ExercicioAlura.entities.DadosLivros;
import com.literAlura.ExercicioAlura.service.ConverteDados;
import com.literAlura.ExercicioAlura.service.LivroService;

import java.util.Scanner;

public class Principal {

    Scanner sc = new Scanner(System.in);
    ConverteDados converteDados = new ConverteDados();

    LivroService livroService = new LivroService();


    private final String ENDERECO = "https://gutendex.com/books/";

    public DadosLivros exibeMenu() {

        var json = livroService.obterDados(ENDERECO);
        DadosLivros dadosLivros = converteDados.obterDados(json, DadosLivros.class);
        System.out.println(dadosLivros);

        return dadosLivros;
    }
}
