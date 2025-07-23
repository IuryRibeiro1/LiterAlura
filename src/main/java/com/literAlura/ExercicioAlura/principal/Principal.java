package com.literAlura.ExercicioAlura.principal;

import com.literAlura.ExercicioAlura.dto.LivroDTO;
import com.literAlura.ExercicioAlura.entities.AutorLivros;
import com.literAlura.ExercicioAlura.entities.DadosLivros;
import com.literAlura.ExercicioAlura.service.ConverteDados;
import com.literAlura.ExercicioAlura.service.LivroService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    Scanner sc = new Scanner(System.in);
    ConverteDados converteDados = new ConverteDados();

    LivroService livroService = new LivroService();

    List<LivroDTO> livroDTO = new ArrayList<>();
    

    List<AutorLivros> autorDTO = new ArrayList<AutorLivros>();


    int opcao = 1;

    private final String ENDERECO = "https://gutendex.com/books/";

    public void exibeMenu() {

        while (opcao != 0) {

            System.out.println("MENU: " +
                    "\n1: Buscar livro pelo título ou autor" +
                    "\n2: Listar livros registrados" +
                    "\n3: Listar autores buscados" +
                    "\n4: Buscar autores por ano determinado");


            int escolha = sc.nextInt();

            if (escolha == 1) {
                buscarLivros();
            }else if(escolha ==2){
                listarLivrosBuscados();
            }
            else if (escolha == 3) {
                listarAutoresBuscados();
            }
            else if(escolha ==4){
                listarAutoresPorDeterminadoAno();
            }
            else {
                opcao = 0;

            }

        }

    }


    private DadosLivros buscarLivroPeloTitulo () {
                System.out.println("Insira o título do livro desejado");
                sc.next();
                String nomeLivro = sc.nextLine();
                var json = livroService.obterDados(ENDERECO + "?search=" + nomeLivro.replace(" " , "%20"));
                DadosLivros dadosLivros = converteDados.obterDados(json, DadosLivros.class);

                System.out.println(dadosLivros.dados().get(0));

        return dadosLivros;
    }

    private void buscarLivros() {
        DadosLivros livrosFiltrados = buscarLivroPeloTitulo();
        livroDTO.add(livrosFiltrados.dados().get(0));


    }

    private void listarLivrosBuscados(){
        livroDTO.forEach(System.out::println);
    }


    private void listarAutoresBuscados() {
        System.out.println("Autores já buscados: ");
         autorDTO = livroDTO.stream()
                 .map(a -> a.getAutor().get(0))
                 .collect(Collectors.toList()).reversed();

         autorDTO.forEach(System.out::println);

    }

    private void listarAutoresPorDeterminadoAno() {
        System.out.println("Insira uma data para buscar algum autor: ");
        Integer ano = sc.nextInt();
        autorDTO = livroDTO.stream()
                .map(a -> a.getAutor().get(0))
                .filter(a -> ano > a.nascimento() && ano < a.falecimento())
                .collect(Collectors.toList()).reversed();

        autorDTO.forEach(System.out::println);

    }

}
