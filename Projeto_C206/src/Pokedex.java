package Projeto_C206.src;
import java.util.ArrayList;

public class Pokedex {
    private ArrayList<PokemanoCapturado> pokemanos;
    private Treinador treinador;


    // Constructor
    public Pokedex(Treinador treinador) {
        Arquivo.setFileName("pokemanos_" + treinador.getNome().toLowerCase() + ".txt");
        this.treinador = treinador;
        pokemanos = Arquivo.ler();
    }

    public void adicionarPokemano(PokemanoCapturado pokemano) {
        Arquivo.escrever(pokemano);
        System.out.println("[" + pokemano.getNome() + "] adicionado a pokedex de " + treinador.getNome());
    }

    public void removerPokemano(String nomeRemover) {
        Arquivo.deletarPokemano(nomeRemover);
    }
    
    public void procurarPorTipo(String tipo) {
        tipo = tipo.trim();
        System.out.println("Pokemanos do tipo " + tipo + ": ");
        
        boolean foundAny = false;
        for (PokemanoCapturado p : pokemanos) {
            if (p.getTipo().equalsIgnoreCase(tipo)) {
                foundAny = true;
                p.mostrarInfos();
            }
        }

        if(!foundAny){
            System.out.println("| Nenhum pokemano desse tipo na pokedex de " + treinador.getNome());
            System.out.println();
        }
    }

    public void listarPokemanos() {
        pokemanos = Arquivo.ler();

        if(pokemanos.isEmpty()){
            System.out.println("| Pokedex vazia!\n");
            return;
        }

        System.out.println("Lista de pokemanos:");
        for (PokemanoCapturado p : pokemanos) {
            p.mostrarInfos();
        }
        System.out.println();
    }

    public void trocarNomePokemano(String nomeAtual, String nomeNovo) {
        Arquivo.updateNome(nomeAtual, nomeNovo);
    }

    public void limparPokedex() {
        Arquivo.limpar();
    }


    // Getters & Setters
    public ArrayList<PokemanoCapturado> getPokemanos() {
        return pokemanos;
    }
}
