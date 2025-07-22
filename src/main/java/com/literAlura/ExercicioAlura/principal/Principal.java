package com.literAlura.ExercicioAlura.principal;

import com.literAlura.ExercicioAlura.dto.LivroDTO;
import com.literAlura.ExercicioAlura.entities.DadosLivros;
import com.literAlura.ExercicioAlura.service.ConverteDados;
import com.literAlura.ExercicioAlura.service.LivroService;

import java.util.Scanner;

public class Principal {

    Scanner sc = new Scanner(System.in);
    ConverteDados converteDados = new ConverteDados();

    LivroService livroService = new LivroService();

    int opcao = 1;

    private final String ENDERECO = "https://gutendex.com/books/";

    public void exibeMenu() {

        while (opcao != 0) {

            System.out.println("MENU: " +
                    "\n1: Buscar livro pelo título ou autor" +
                    "\n2: Listar livros registrados" +
                    "\n3: Listar autores registrados" +
                    "\n4: buscar livros pelo idioma");


            int escolha = sc.nextInt();

            if (escolha == 1) {
                buscarLivroPeloTitulo();
            } else if (escolha == 2) {
                System.out.println("Vc é zicado");
            } else {
                opcao = 0;

            }

        }

    }
            public void buscarLivroPeloTitulo () {
                System.out.println("Insira o título do livro desejado");
                sc.next();
                String nomeLivro = sc.nextLine();
                var json = livroService.obterDados(ENDERECO + "?search=" + nomeLivro.replace(" " , "+"));

                DadosLivros dadosLivros = converteDados.obterDados(json, DadosLivros.class);
                System.out.println(dadosLivros);

            }

        }
