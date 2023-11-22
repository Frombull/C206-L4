package Projeto_C206;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pokedex pokedex = new Pokedex();
        boolean running = true;

        // Comecando com alguns pokemons iniciais na pokedex
        if(pokedex.getPokemons().isEmpty()) {
            pokedex.adicionarPokemano(new PokemanoCapturado("Charmano", "Fogo", 1, "Normal", "Marco"));
            pokedex.adicionarPokemano(new PokemanoCapturado("Boobasauro", "Agua", 2, "Normal", "Marco"));
            pokedex.adicionarPokemano(new PokemanoCapturado("Pikachuchu", "Eletrico", 3, "Ultraball", "Vinicius"));
        }

        // Menu
        while (running) {
            System.out.println("---------- Menu ----------");
            System.out.println("1. Adicionar pokemano");
            System.out.println("2. Procurar por tipo");
            System.out.println("3. Listar pokemanos");
            System.out.println("4. Trocar treinador de pokemano");
            System.out.println("5. Remover pokemano");
            System.out.println("6. Limpar pokedex");
            System.out.println("7. Sair");
            System.out.println("--------------------------\n");
            System.out.print("-> ");

            // Lendo entrada do usuario
            int userInput;
            if(scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Opcao invalida.\n");
                scanner.nextLine();
                continue;
            }

            switch (userInput) {
                case 1:
                    System.out.print("-> Nome do pokemano: ");
                    String nome = scanner.nextLine();

                    System.out.print("-> Tipo do pokemano: ");
                    String tipo = scanner.nextLine();

                    int idade;
                    while (true) {
                        System.out.print("-> Idade do pokemano: ");
                        if (scanner.hasNextInt() && (idade = scanner.nextInt()) >= 0) {
                            scanner.nextLine();
                            break;
                        }
                        scanner.nextLine();
                    }
                    
                    System.out.print("-> Pokebola: ");
                    String pokebola = scanner.nextLine();

                    System.out.print("-> Nome do Treinador: ");
                    String nomeTreinador = scanner.nextLine();

                    PokemanoCapturado novopokemano = new PokemanoCapturado(nome, tipo, idade, pokebola, nomeTreinador);
                    pokedex.adicionarPokemano(novopokemano);
                    break;
                case 2:
                    System.out.print("-> Procurar por tipo: ");
                    String tipoProcurar = scanner.nextLine();
                    System.out.println();

                    pokedex.procurarPorTipo(tipoProcurar);
                    break;
                case 3:
                    pokedex.listarPokemanos();
                    break;
                case 4:
                    System.out.print("-> Nome do pokemano: ");
                    String nomePokemano = scanner.nextLine();
                    System.out.print("-> Nome do novo treinador: ");
                    String nomeTreinadorNovo = scanner.nextLine();
                    pokedex.trocarTreinador(nomePokemano, nomeTreinadorNovo);
                    break;
                case 5:
                    System.out.print("-> Nome do pokemano a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    pokedex.removerPokemano(nomeRemover);
                    break;
                case 6:
                    while (true) {
                        System.out.print("-> Tem certeza que deseja deletar todos os seus pokemanos? (sim/nao): ");
                
                        String resposta = scanner.nextLine().toLowerCase();
                
                        if (resposta.equals("sim") || resposta.equals("s")) {
                            Arquivo.limpar();
                            System.out.println("Pokemanos deletados com sucesso!\n");
                            break;
                        } else if (resposta.equals("nao") || resposta.equals("n")) {
                            System.out.println("Cancelado!\n");
                            break;
                        } else {
                            continue;
                        }
                    }

                    break;
                case 7:
                    System.out.println("Ja vai?");
                    running = false;
                    break;
                default:
                    System.out.println("Opçao invalida.\n");
            }
        }
        scanner.close();
    }
}
