package Projeto_C206;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Treinador> treinadores;
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        // Criando treinadores iniciais
        treinadores = ArquivoTreinadores.ler();

        if(treinadores.isEmpty()) {
            Treinador treinador1 = new Treinador("Marco", 1);
            Treinador treinador2 = new Treinador("Vinicius", 2);
            treinadores.add(treinador1);
            treinadores.add(treinador2);
            ArquivoTreinadores.escrever(treinador1);
            ArquivoTreinadores.escrever(treinador2);
        }
        
        // Escolhendo treinador
        Treinador treinadorSelecionado = null;

        while(treinadorSelecionado == null) {
            System.out.println("Qual treinador deseja escolher?");
            for (Treinador treinador : treinadores) {
                System.out.println("| " + treinador.getNome());
            }

            System.out.println();
            System.out.print("-> ");
            String treinadorEscolhido = scanner.nextLine().trim();
            for (Treinador t : treinadores) {
                if (t.getNome().equalsIgnoreCase(treinadorEscolhido)) {
                    System.out.println(treinadorEscolhido + " Selecionado.");
                    System.out.println("==============================");
                    System.out.println();
                    treinadorSelecionado = t;
                    break;
                }
            }
        }

        Pokedex pokedex = treinadorSelecionado.getPokedex();

        while (running) {
            // Selecionando o arquivo '.txt' do treinador selecionado
            Arquivo.setFileName("pokemanos_" + treinadorSelecionado.getNome().toLowerCase() + ".txt");

            // Atualizando lista de treinadores disponivel
            treinadores = ArquivoTreinadores.ler();

            // Menu
            System.out.println("---------- Menu ----------");
            System.out.println("1. Adicionar pokemano");
            System.out.println("2. Procurar pokemano por tipo");
            System.out.println("3. Listar pokemanos");
            System.out.println("4. Trocar nome de pokemano");
            System.out.println("5. Remover pokemano");
            System.out.println("6. Limpar pokedex");
            System.out.println("7. Adicionar treinador");
            System.out.println("8. Trocar nome de treinador");
            System.out.println("9. Selecionar outro treinador");
            System.out.println("10. Remover treinador");
            System.out.println("11. Sair");
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
                    System.out.print("-> Nome atual do pokemano: ");
                    String nomePokemano = scanner.nextLine();
                    System.out.print("-> Novo nome do pokemano: ");
                    String nomeNovo = scanner.nextLine();
                    pokedex.trocarNomePokemano(nomePokemano, nomeNovo);
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
                            pokedex.limparPokedex();
                            System.out.println("Pokemanos de " + treinadorSelecionado.getNome() + " deletados com sucesso!\n");
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
                    System.out.print("-> Nome do novo treinador: ");
                    String nomeNovoTreinador = scanner.nextLine().trim();

                    int numPokebolas;
                    while (true) {
                        System.out.print("-> Numero de pokebolas que possui: ");
                        if (scanner.hasNextInt() && (numPokebolas = scanner.nextInt()) >= 0) {
                            scanner.nextLine();
                            break;
                        }
                        scanner.nextLine();
                    }

                    treinadores.add(new Treinador(nomeNovoTreinador, numPokebolas));
                    ArquivoTreinadores.escrever(new Treinador(nomeNovoTreinador, numPokebolas));

                    System.out.println(nomeNovoTreinador + " adicionado com sucesso!\n");
                    break;
                case 8:
                    System.out.print("-> Nome atual do treinador: ");
                    String nomeTreinadorAtual = scanner.nextLine();
                    System.out.print("-> Novo nome do treinador: ");
                    String nomeTreinadorNovo = scanner.nextLine();
                    ArquivoTreinadores.updateNome(nomeTreinadorAtual, nomeTreinadorNovo);
                    break;
                case 9:
                    treinadorSelecionado = null;

                    while(treinadorSelecionado == null) {
                        System.out.println("Qual treinador deseja escolher?");
                        for (Treinador treinador : treinadores) {
                            System.out.println("| " + treinador.getNome());
                        }

                        System.out.println();
                        System.out.print("-> ");
                        String treinadorEscolhido = scanner.nextLine().trim();
                        for (Treinador t : treinadores) {
                            if (t.getNome().equalsIgnoreCase(treinadorEscolhido)) {
                                System.out.println(treinadorEscolhido + " Selecionado.");
                                System.out.println("==============================");
                                System.out.println();
                                treinadorSelecionado = t;
                                break;
                            }
                        }
                    }
                    break;
                case 10:
                if(ArquivoTreinadores.ler().size() <= 1){
                    System.out.println("Nao ha treinadores para serem removidos");
                    break;
                }

                String nomeARemover;
                while (true) {
                        for (Treinador treinador : treinadores) {
                            System.out.println("| " + treinador.getNome());
                        }
                        System.out.print("-> Nome do treinador para ser removido: ");
                        nomeARemover = scanner.nextLine();
                        if(treinadorSelecionado.getNome().equalsIgnoreCase(nomeARemover))
                            System.out.println("Nao pode remover o treinador atualmente selecionado");
                        else
                            break;
                    }

                    ArquivoTreinadores.deletarTreinador(nomeARemover);

                    break;
                case 11:
                    while (true) {
                        System.out.print("-> Ja vai? (sim/nao): ");
                        String resposta = scanner.nextLine().toLowerCase();
                
                        if (resposta.equals("sim") || resposta.equals("s")) {
                            running = false;
                            break;
                        } else if (resposta.equals("nao") || resposta.equals("n")) {
                            System.out.println("Cancelado!\n");
                            break;
                        } else {
                            continue;
                        }
                    }
                    break;
                default:
                    System.out.println("Opcao invalida.\n");
            }
        }
        scanner.close();
    }
}
