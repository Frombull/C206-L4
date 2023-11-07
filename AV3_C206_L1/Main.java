package AV3_C206_L1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        Arquivo arq = new Arquivo();
        boolean running = true;
        ArrayList<Filme> filmes;

        while (running) {
            filmes = arq.ler();

            if(filmes.isEmpty()){
                System.out.println("Lista vazia.");
            }

            // Menu
            System.out.println("""
                    Seleciona uma opcao ae:\s
                    1. Cadastrar filme
                    2. Listar filmes
                    3. Ordenar filmes de A-Z
                    4. Ordenar filmes de Z-A
                    """);
            System.out.print("-> ");
            int userInput = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (userInput) {
                case 1 -> {
                    Filme filme = new Filme();

                    System.out.print("Nomin: ");
                    filme.setNomeFilme(sc.nextLine());
                    System.out.print("Generin: ");
                    filme.setGeneroFilme(sc.nextLine());
                    System.out.print("Duracel: ");
                    try {
                        int duracaoMin = sc.nextInt();
                        if (duracaoMin <= 0) {
                            throw new DuracaoNegativaException();
                        }
                        filme.setDuracaoMin(duracaoMin);
                        System.out.println();
                    } catch (DuracaoNegativaException e) {
                        System.out.println(e);
                        System.out.println("====================\n");
                        break;
                    }
                    arq.escrever(filme);
                }
                case 2 -> {
                    System.out.println("Lista de filmes:");
                    System.out.println("| --------------------");
                    for (Filme f : filmes) {
                        System.out.println("| Nome: " + f.getNomeFilme());
                        System.out.println("| Genero: " + f.getGeneroFilme());
                        System.out.println("| Duracao: " + f.getDuracaoMin());
                        System.out.println("| --------------------");
                    }
                    System.out.println();
                }
                case 3 -> {
                    Collections.sort(filmes);
                    System.out.println("Em ordem crescente:");
                    System.out.println("| -------------------->");
                    for (Filme f : filmes) {
                        System.out.println("| Nome: " + f.getNomeFilme());
                        System.out.println("| Genero: " + f.getGeneroFilme());
                        System.out.println("| Duracao: " + f.getDuracaoMin());
                        System.out.println("| -------------------->");
                    }
                    System.out.println();
                }
                case 4 -> {
                    filmes.sort(Collections.reverseOrder());
                    System.out.println("Em ordem decrescente: ");
                    System.out.println("| <--------------------");
                    for (Filme f : filmes) {
                        System.out.println("| Nome: " + f.getNomeFilme());
                        System.out.println("| Genero: " + f.getGeneroFilme());
                        System.out.println("| Duracao: " + f.getDuracaoMin());
                        System.out.println("| <--------------------");
                    }
                    System.out.println();
                }
                default -> {
                    System.out.println("Ja vai?\n");
                    running = false;
                }
            }
        }
        sc.close();
    }
}
