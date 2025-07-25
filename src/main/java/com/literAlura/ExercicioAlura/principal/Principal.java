package com.literAlura.ExercicioAlura.principal;

import com.literAlura.ExercicioAlura.dto.LivroDTO;
import com.literAlura.ExercicioAlura.entities.Autor;
import com.literAlura.ExercicioAlura.entities.AutorLivros;
import com.literAlura.ExercicioAlura.entities.DadosLivros;
import com.literAlura.ExercicioAlura.entities.Livros;
import com.literAlura.ExercicioAlura.repository.AutorRepositorio;
import com.literAlura.ExercicioAlura.repository.LivroRepositorio;
import com.literAlura.ExercicioAlura.service.ConverteDados;
import com.literAlura.ExercicioAlura.service.LivroService;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    Scanner sc = new Scanner(System.in);
    ConverteDados converteDados = new ConverteDados();

    LivroService livroService = new LivroService();

    List<LivroDTO> livroDTO = new ArrayList<>();

    LivroRepositorio livroRepositorio;
    AutorRepositorio autorRepositorio;

    List<Livros> livros = new ArrayList<>();

    List<LivroDTO> autorLivros = new ArrayList<LivroDTO>();


    int opcao = 1;

    private final String ENDERECO = "https://gutendex.com/books/";

    public Principal(LivroRepositorio livroRepositorio, AutorRepositorio autorepositorio) {
        this.livroRepositorio = livroRepositorio;
        this.autorRepositorio = autorepositorio;
    }

    public void exibeMenu() {

        while (opcao != 0) {

            System.out.println("MENU: " +
                    "\n1: Buscar livro pelo título ou autor" +
                    "\n2: Listar livros registrados" +
                    "\n3: Listar autores registrados" +
                    "\n4: Buscar autores por ano determinado" +
                    "\n5: Buscar livros em determinado idioma");


            int escolha = sc.nextInt();

            if (escolha == 1) {
                buscarLivros();
            } else if (escolha == 2) {
                listarLivrosBuscados();
            } else if (escolha == 3) {
                listarAutoresBuscados();
            } else if (escolha == 4) {
                listarAutoresPorDeterminadoAno();
            } else if (escolha == 5) {
                listarLivroEmDeterminadoIdioma();
            } else {
                opcao = 0;

            }

        }

    }

    private LivroDTO buscarLivroPeloTitulo() {
        System.out.println("Insira o título do livro desejado");
        sc.next();
        String nomeLivro = sc.nextLine();
        if (nomeLivro.trim().isEmpty()) {
            System.out.println("Busca cancelada. Por favor, insira um título.");
            return buscarLivroPeloTitulo();
        }
        var json = livroService.obterDados(ENDERECO + "?search=" + nomeLivro.replace(" ", "%20"));
        DadosLivros dadosLivros = converteDados.obterDados(json, DadosLivros.class);

        LivroDTO livroEncontrado = dadosLivros.dados().get(0);

        return livroEncontrado;

    }

    private void buscarLivros() {
        LivroDTO livroEncontrado = buscarLivroPeloTitulo();
        Livros livros = new Livros(livroEncontrado);

        livroRepositorio.save(livros);
        System.out.println(livros);
    }

    private void listarLivrosBuscados() {
        livros = livroRepositorio.findAll();
        livros.stream()
                .sorted(Comparator.comparing(Livros::getId))
                .forEach(System.out::println);
    }

    private void listarAutoresBuscados() {
        listarLivrosBuscados();
        System.out.println("Digite o nome do autor que deseja buscar:");
        sc.nextLine();
        String nomeAutor = sc.nextLine();
        List<Autor> autoresEncontrados = autorRepositorio.findByNomeContainingIgnoreCase(nomeAutor);

        if (autoresEncontrados.isEmpty()) {

            System.out.println("Nenhum autor encontrado com o nome '" + nomeAutor + "'.");

        } else {
            System.out.println("\n--- Autores Encontrados ---");
            autoresEncontrados.forEach(autor ->
                    System.out.println(" Nome: " + autor.nome +
                            "\n  Nascimento: " + autor.nascimento +
                            "\n  Falecimento: " + autor.anoMorte +
                            "\n  Livros: " + autor.getLivros().get(0).titulo));
        }
    }

    private void listarAutoresPorDeterminadoAno() {
        System.out.println("Insira uma data para buscar algum autor: ");
        Integer anoEscolhido = sc.nextInt();

        List<Autor> anoSelecionado = autorRepositorio.findByAnoEscolhido(anoEscolhido);

        if(anoSelecionado.isEmpty()){
            System.out.println("Nenhum autor encontrado na data selecionada");
        }
        else{
            anoSelecionado.forEach(System.out::println);
        }

    }

    private void listarLivroEmDeterminadoIdioma() {
        System.out.println("Escolha um idioma para realizar busca " +
                            "\npt- Português"  +
                            "\nen- Inglês"   +
                            "\nes- Espanhol" +
                            "\nfr- Francês");

        sc.next();
        String idiomaEscolhido = sc.nextLine();
        List<Livros> livroIdioma = livroRepositorio.buscarPorIdioma(idiomaEscolhido);

        if(livroIdioma.isEmpty()){
            System.out.println("Idioma selecionado não foi encontrado: ");
        }
        else{
            livroIdioma.forEach(System.out::println);
        }



    }

}
