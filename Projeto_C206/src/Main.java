package Projeto_C206.src;
import java.util.Scanner;

public class Main {
    // Variaveis de classe
    private static final Scanner scanner = new Scanner(System.in);
    private static Pokedex pokedex;
    private static Treinador treinadorSelecionado;


    public static void main(String[] args) {
        boolean running = true;

        // Comecando com alguns treinadores iniciais
        if(ArquivoTreinadores.ler().isEmpty()) {
            Treinador treinador1 = new Treinador("Marco", 1);
            Treinador treinador2 = new Treinador("Vinicius", 2);
            ArquivoTreinadores.escrever(treinador1);
            ArquivoTreinadores.escrever(treinador2);
        }
        
        // Escolhendo treinador
        escolherTreinador();

        while (running) {
            // Selecionando o arquivo '.txt' do treinador selecionado
            Arquivo.setFileName("pokemanos_" + treinadorSelecionado.getNome().toLowerCase() + ".txt");

            // Menu
            exibirMenu();
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
                    adicionarPokemano();
                    break;
                case 2:
                    procurarPorTipo();
                    break;
                case 3:
                    listarPokemanos();
                    break;
                case 4:
                    trocarNomePokemano();
                    break;
                case 5:
                    removerPokemano();
                    break;
                case 6:
                    limparPokedex();
                    break;
                case 7:
                    adicionarTreinador();
                    break;
                case 8:
                    trocarNomeTreinador();
                    break;
                case 9:
                    selecionarOutroTreinador();
                    break;
                case 10:
                    removerTreinador();
                    break;
                case 11:
                    running = sair();
                    break;
                default:
                    System.out.println("Opcao invalida.\n");
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
            System.out.println("---------- Menu ----------");
            System.out.println(" 1. Adicionar pokemano");
            System.out.println(" 2. Procurar pokemano por tipo");
            System.out.println(" 3. Listar pokemanos");
            System.out.println(" 4. Trocar nome de pokemano");
            System.out.println(" 5. Remover pokemano");
            System.out.println(" 6. Limpar pokedex");
            System.out.println(" 7. Adicionar treinador");
            System.out.println(" 8. Trocar nome de treinador");
            System.out.println(" 9. Selecionar outro treinador");
            System.out.println("10. Remover treinador");
            System.out.println("11. Sair");
            System.out.println("--------------------------\n");
    }

    private static void adicionarPokemano() {
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

        String nomeTreinador = treinadorSelecionado.getNome();

        PokemanoCapturado novopokemano = new PokemanoCapturado(nome, tipo, idade, pokebola, nomeTreinador);
        pokedex.adicionarPokemano(novopokemano);
    }

    private static void procurarPorTipo() {
        System.out.print("-> Procurar por tipo: ");
        String tipoProcurar = scanner.nextLine();
        System.out.println();

        pokedex.procurarPorTipo(tipoProcurar);
    }

    private static void listarPokemanos () {
        pokedex.listarPokemanos();
    }

    private static void trocarNomePokemano () {
        System.out.print("-> Nome atual do pokemano: ");
        String nomePokemano = scanner.nextLine();
        System.out.print("-> Novo nome do pokemano: ");
        String nomeNovo = scanner.nextLine();
        pokedex.trocarNomePokemano(nomePokemano, nomeNovo);
    }

    private static void removerPokemano() {
        System.out.print("-> Nome do pokemano a ser removido: ");
        String nomeRemover = scanner.nextLine();
        pokedex.removerPokemano(nomeRemover);
    }

    private static void limparPokedex() {
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
            }
        }
    }

    private static void adicionarTreinador() {
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

        ArquivoTreinadores.escrever(new Treinador(nomeNovoTreinador, numPokebolas));

        System.out.println(nomeNovoTreinador + " adicionado com sucesso!\n");
    }

    private static void trocarNomeTreinador() {
        System.out.print("-> Nome atual do treinador: ");
        String nomeTreinadorAtual = scanner.nextLine();
        System.out.print("-> Novo nome do treinador: ");
        String nomeTreinadorNovo = scanner.nextLine();
        ArquivoTreinadores.updateNome(nomeTreinadorAtual, nomeTreinadorNovo);
    }

    private static void selecionarOutroTreinador() {
        treinadorSelecionado = null;

        while(treinadorSelecionado == null) {
            System.out.println("Qual treinador deseja escolher?");
            for (Treinador treinador : ArquivoTreinadores.ler()) {
                System.out.println("| " + treinador.getNome());
            }

            System.out.println();
            System.out.print("-> ");
            String treinadorEscolhido = scanner.nextLine().trim();
            for (Treinador t : ArquivoTreinadores.ler()) {
                if (t.getNome().equalsIgnoreCase(treinadorEscolhido)) {
                    System.out.println(treinadorEscolhido + " Selecionado.");
                    System.out.println("==============================");
                    System.out.println();
                    treinadorSelecionado = t;
                    break;
                }
            }
        }
    }

    private static void removerTreinador() {
        if(ArquivoTreinadores.ler().size() <= 1)
            System.out.println("Nao ha treinadores para serem removidos");

        String nomeARemover;
        while (true) {
                for (Treinador treinador : ArquivoTreinadores.ler()) {
                    System.out.println("| " + treinador.getNome());
                }
                System.out.print("-> Nome do treinador para ser removido: ");
                nomeARemover = scanner.nextLine();
                if(treinadorSelecionado.getNome().equalsIgnoreCase(nomeARemover))
                    System.out.println("\nNao pode remover o treinador atualmente selecionado");
                else
                    break;
            }

        ArquivoTreinadores.deletarTreinador(nomeARemover);
    }

    private static boolean sair() {
        while (true) {
            System.out.print("-> Ja vai? (sim/nao): ");
            String resposta = scanner.nextLine().toLowerCase();
    
            if (resposta.equals("sim") || resposta.equals("s")) {
                return false;
            } else if (resposta.equals("nao") || resposta.equals("n")) {
                System.out.println("Cancelado!\n");
                return true;
            }
        }
    }

    private static void escolherTreinador() {
        treinadorSelecionado = null;
        System.out.println();
        while(treinadorSelecionado == null) {
            for (Treinador treinador : ArquivoTreinadores.ler()) {
                System.out.println("| " + treinador.getNome());
            }
            
            System.out.print("-> Qual treinador deseja escolher: ");
            String treinadorEscolhido = scanner.nextLine().trim();
            for (Treinador t : ArquivoTreinadores.ler()) {
                if (t.getNome().equalsIgnoreCase(treinadorEscolhido)) {
                    System.out.println(treinadorEscolhido + " Selecionado.");
                    System.out.println("==============================");
                    System.out.println();
                    treinadorSelecionado = t;
                    break;
                }
            }
        }

        pokedex = treinadorSelecionado.getPokedex();
    }

}
