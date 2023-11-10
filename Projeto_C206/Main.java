package Projeto_C206;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pokedex pokedex = new Pokedex();
        boolean running = true;

        // Pokemanos iniciais
        pokedex.adicionarPokemano(new PokemanoCapturado("Charmano", "Fogo", 1, "Normal", "Marco"));
        pokedex.adicionarPokemano(new PokemanoCapturado("Boobasauro", "Agua", 2, "Normal", "Marco"));
        pokedex.adicionarPokemano(new PokemanoCapturado("Pikachuchu", "Eletrico", 3, "Normal", "Vinicius"));

        // Menu
        while (running) {
            System.out.println("---------- Menu ----------");
            System.out.println("1. Adicionar pokemano");
            System.out.println("2. Remover pokemano");
            System.out.println("3. Listar pokemanos");
            System.out.println("4. Procurar por tipo");
            System.out.println("5. Sair");
            // TODO fazer ler e salvar no arquivo de texto
            System.out.println("--------------------------\n");
            System.out.print("-> ");
            int userInput = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (userInput) {
                case 1:
                    System.out.print("Nome do pokemano: ");
                    String nome = scanner.nextLine();

                    System.out.print("Tipo do pokemano: ");
                    String tipo = scanner.nextLine();

                    System.out.print("Idade do pokemano: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Pokebola: ");
                    String pokebola = scanner.nextLine();

                    System.out.print("Nome do Treinador: ");
                    String nomeTreinador = scanner.nextLine();

                    PokemanoCapturado novopokemano = new PokemanoCapturado(nome, tipo, idade, pokebola, nomeTreinador);
                    pokedex.adicionarPokemano(novopokemano);
                    break;
                case 2:
                    System.out.print("Nome do pokemano a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    pokedex.removerPokemano(nomeRemover);
                    break;
                case 3:
                    pokedex.listarPokemanos();
                    break;
                case 4:
                    System.out.print("-> Procurar por tipo: ");
                    String tipoProcurar = scanner.nextLine();
                    System.out.println();

                    pokedex.procurarPorTipo(tipoProcurar);
                    break;
                case 5:
                    System.out.println("Já vai?");
                    running = false;
                    break;
                default:
                    System.out.println("Opçao inválida.");
            }
        }
        scanner.close();
    }
}
